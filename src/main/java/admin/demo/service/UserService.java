package admin.demo.service;

import admin.demo.exception.UserCollectionException;
import admin.demo.model.Account;
import admin.demo.repository.AccountRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getUserAccounts() {
        List<Account> userAccounts = accountRepository.findAll();
        return userAccounts;
    }

    public Account getUserDetails(Account userCredentials) throws UserCollectionException {
        Account resultAccount = accountRepository.findByEmail(userCredentials.getEmail());
        System.out.println(userCredentials.getEmail());
        if (resultAccount == null) {
            throw new UserCollectionException(UserCollectionException.NotFoundExeption());
        } else {
            return resultAccount;
        }

    }

    public Account saveNewUser(Account user) throws UserCollectionException {

        Account resultAccount = accountRepository.findByEmail(user.getEmail());
        if (resultAccount == null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = dtf.format(now);
            user.setCreatedOn(LocalDate.from(now));
            return accountRepository.saveAndFlush(user);
        } else {
            throw new UserCollectionException(UserCollectionException.UserAlreadyExist());
        }

    }

    public Integer updateUser(Account user) {
        Optional<Account> optionalUser = accountRepository.findById(user.getUserId());
        if (optionalUser.isPresent()) {
            accountRepository.saveAndFlush(user);
            return 1;
        } else {
            return 0;
        }
    }

    public String deleteUser(Integer userId) throws UserCollectionException {
        accountRepository.deleteById(userId);
        Optional<Account> deletedUser = accountRepository.findById(userId);
        if (deletedUser.isPresent()) {
            throw new UserCollectionException(UserCollectionException.CannotDeleteUser());
        } else {
            return "Successfully deleted user";
        }

    }
}
