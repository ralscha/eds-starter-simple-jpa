package ch.rasc.eds.starter.service;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import ch.rasc.eds.starter.entity.User;
import ch.rasc.eds.starter.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@ExtDirectMethod(STORE_READ)
	public List<User> read() {
		return this.userRepository.findAll();
	}

	@ExtDirectMethod(STORE_MODIFY)
	public ExtDirectStoreResult<User> create(User newUser) {
		User insertedUser = this.userRepository.save(newUser);
		return new ExtDirectStoreResult<>(insertedUser);
	}

	@ExtDirectMethod(STORE_MODIFY)
	public ExtDirectStoreResult<User> update(User changedUser) {
		User updatedUser = this.userRepository.save(changedUser);
		return new ExtDirectStoreResult<>(updatedUser);
	}

	@ExtDirectMethod(STORE_MODIFY)
	public void destroy(User destroyedUser) {
		this.userRepository.delete(destroyedUser);
	}

}
