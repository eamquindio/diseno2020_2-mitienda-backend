package co.edu.eam.disenosoftware.mitienda.services;

import co.edu.eam.disenosoftware.mitienda.exceptions.BusinessException;
import co.edu.eam.disenosoftware.mitienda.exceptions.ErrorCodesEnum;
import co.edu.eam.disenosoftware.mitienda.model.entities.User;
import co.edu.eam.disenosoftware.mitienda.repositories.UserRepository;
import co.edu.eam.disenosoftware.mitienda.utils.EncrypterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService service
 */
@Service
@Transactional
public class UserService {
  /**
   * autowired
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * function create user
   *
   * @param name     ,     name
   * @param phone    ,    phone
   * @param username , username
   * @param email    ,    email
   * @param password , password
   * @return user user created
   */
  public User createUser(String name, String phone, String username, String email, String password) {

    User userEmail = userRepository.getUserByEmail(email);
    User userName = userRepository.getUserByUserName(username);

    password = EncrypterUtil.getMD5(password);

    int longitud = email.length();
    char letraCorreo;
    boolean validadorArroba = false;
    boolean validadorPunto = false;

    if (userEmail != null) {
      throw new BusinessException("Error", ErrorCodesEnum.EMAIL_ALREADY_EXIST);

    }

    if (userName != null) {
      throw new BusinessException("Error", ErrorCodesEnum.USERNAME_ALREADY_EXIST);

    }

    for (char i = 0; i < longitud; i++) {
      letraCorreo = email.charAt(i);
      if (letraCorreo == '@' && i == 0) {
        throw new BusinessException("El correo es incorrecto", ErrorCodesEnum.EMAIL_ERROR);
      }

      if (letraCorreo == '@') {
        validadorArroba = true;
      }

      if (letraCorreo == '.') {
        validadorPunto = true;
      }
    }

    if (!validadorArroba) {
      throw new BusinessException("El correo es incorrecto", ErrorCodesEnum.EMAIL_ERROR);
    }

    if (!validadorPunto) {
      throw new BusinessException("El correo es incorrecto", ErrorCodesEnum.EMAIL_ERROR);
    }

    boolean userPhone = userRepository.isNumeric(phone);

    if (!userPhone) {
      throw new BusinessException("El telefono es incorrecto", ErrorCodesEnum.PHONE_NUMBERS);
    }

    User user = new User(username, phone, email, password, name);
    userRepository.create(user);

    return user;
  }

  /**
   * function user login
   *
   * @param username , username
   * @param password , password
   * @return , list
   */
  public User userLogin(String username, String password) {

    User userName = userRepository.getUserByUserName(username);

    if (userName == null) {
      throw new BusinessException("The username or password is incorrect", ErrorCodesEnum.LOGIN_INCORRECT);
    }

    if (!userName.getPassword().equals(EncrypterUtil.getMD5(password))) {
      throw new BusinessException("The username or password is incorrect", ErrorCodesEnum.LOGIN_INCORRECT);
    }

    return userName;
  }


}
