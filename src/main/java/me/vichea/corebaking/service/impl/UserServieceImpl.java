package me.vichea.corebaking.service.impl;

import me.vichea.corebaking.dto.AccountInfo;
import me.vichea.corebaking.dto.BankResponse;
import me.vichea.corebaking.dto.UserRequest;
import me.vichea.corebaking.entity.User;
import me.vichea.corebaking.entity.UserStatus;
import me.vichea.corebaking.repository.UserRepository;
import me.vichea.corebaking.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServieceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    /**
     * Create an account - saving a new user in to database
     * @return BankResponse
     */
    @Override
    public BankResponse createAccount(UserRequest userRequest) {


        if (userRepository.existsByEmail(userRequest.getEmail())){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .email(userRequest.getEmail())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .phoneNumber(userRequest.getPhoneNumber())
                .alterNativePhoneNumber(userRequest.getAlterNativePhoneNumber())
                .status(UserStatus.ACTIVE)
                .build();

        User savedUser = userRepository.save(newUser);
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(savedUser.getFirstName())
                        .build())
                .build();
    }

    /**
     * Login to account
     * @return BankResponse
     */

    @Override
    public BankResponse login(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail());
        if (user == null){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_FOUND_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_FOUND_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
                .responseMessage(AccountUtils.ACCOUNT_FOUND_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(user.getAccountBalance())
                        .accountNumber(user.getAccountNumber())
                        .accountName(user.getFirstName())
                        .build())
                .build();
    }

}
