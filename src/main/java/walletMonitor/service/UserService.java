package walletMonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import walletMonitor.dao.UserDao;
import walletMonitor.dto.UserDTO;
import walletMonitor.dto.UserResponse;
import walletMonitor.exception.CustomExceptionEnum;
import walletMonitor.models.User;

@Repository
public class UserService {

	@Autowired
	private UserDao _userDao;

	public UserResponse getByEmail(String email) {
		UserResponse ur = new UserResponse();
		try {
			User user = _userDao.getByEmail(email);
			ur.setUserDTO(new UserDTO(user));
			ur.setSuccess(Boolean.TRUE);
			return ur;
		} catch (Exception ex) {
			ur.setSuccess(Boolean.TRUE);
			return new UserResponse(CustomExceptionEnum.INTERNAL_SYSTEM_EXCEPTION.getResponse());
		}

	}

	public UserResponse getById(Long id) {
		UserResponse ur = new UserResponse();
		try {
			User user = _userDao.getById(id);
			ur.setUserDTO(new UserDTO(user));
			ur.setSuccess(Boolean.TRUE);
			return ur;
		} catch (Exception ex) {
			ex.printStackTrace();
			ur.setSuccess(Boolean.FALSE);
			return new UserResponse(CustomExceptionEnum.INTERNAL_SYSTEM_EXCEPTION.getResponse());
		}

	}

	public UserResponse deleteById(Long id) {
		UserResponse ur = new UserResponse();
		try {
			User user = new User(id);
			_userDao.delete(user);
			ur.setSuccess(Boolean.TRUE);
			return ur;
		} catch (Exception ex) {
			ex.printStackTrace();
			ur.setSuccess(Boolean.FALSE);
			return new UserResponse(CustomExceptionEnum.INTERNAL_SYSTEM_EXCEPTION.getResponse());
		}

	}

	public UserResponse create(UserDTO userDTO) {
		UserResponse ur = new UserResponse();
		try {
			User user = new User(userDTO);
			_userDao.save(user);
			ur.setUserDTO(new UserDTO(user));
			ur.setSuccess(Boolean.TRUE);
			return ur;
		} catch (Exception ex) {
			ex.printStackTrace();
			ur.setSuccess(Boolean.FALSE);
			return new UserResponse(CustomExceptionEnum.INTERNAL_SYSTEM_EXCEPTION.getResponse());
		}

	}

	public UserResponse update(UserDTO userDTO) {
		UserResponse ur = new UserResponse();
		try {

			User user = new User(userDTO);
			_userDao.saveOrUpdate(user);
			user = _userDao.getById(user.getId());
			ur.setUserDTO(new UserDTO(user));
			ur.setSuccess(Boolean.TRUE);
			return ur;
		} catch (Exception ex) {
			ex.printStackTrace();
			ur.setSuccess(Boolean.FALSE);
			return new UserResponse(CustomExceptionEnum.INTERNAL_SYSTEM_EXCEPTION.getResponse());
		}

	}
}
