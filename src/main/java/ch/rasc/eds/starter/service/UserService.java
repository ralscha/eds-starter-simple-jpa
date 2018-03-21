package ch.rasc.eds.starter.service;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import ch.rasc.eds.starter.entity.User;
import ch.rasc.eds.starter.repository.DepartmentRepository;
import ch.rasc.eds.starter.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	private final DepartmentRepository departmentRepository;

	public UserService(UserRepository userRepository,
			DepartmentRepository departmentRepository) {
		this.userRepository = userRepository;
		this.departmentRepository = departmentRepository;
	}

	@ExtDirectMethod(STORE_READ)
	public List<User> read() {
		return this.userRepository.findAll().stream()
				.peek(u -> u.setDepartmentId(u.getDepartment().getId()))
				.collect(Collectors.toList());
	}

	@ExtDirectMethod(STORE_MODIFY)
	public ExtDirectStoreResult<User> create(User newUser) {
		if (newUser.getDepartmentId() > 0) {
			newUser.setDepartment(
					this.departmentRepository.getOne(newUser.getDepartmentId()));
		}
		User insertedUser = this.userRepository.save(newUser);
		return new ExtDirectStoreResult<>(insertedUser);
	}

	@ExtDirectMethod(STORE_MODIFY)
	public ExtDirectStoreResult<User> update(User changedUser) {
		changedUser.setDepartment(
				this.departmentRepository.getOne(changedUser.getDepartmentId()));
		User updatedUser = this.userRepository.save(changedUser);
		return new ExtDirectStoreResult<>(updatedUser);
	}

	@ExtDirectMethod(STORE_MODIFY)
	public void destroy(User destroyedUser) {
		this.userRepository.delete(destroyedUser);
	}

}
