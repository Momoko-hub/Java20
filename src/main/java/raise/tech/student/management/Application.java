package raise.tech.student.management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private StudentRepository repository;

	@GetMapping("/students")
	public String getStudents(@RequestParam String name){
		Student student = repository.searchByName(name);
		return student.getName() + " " + student.getAge() + "歳";
	}

	@PostMapping("/students")
	public void setStudents(String name,int age){
		repository.registerStudent(name, age);
	}

	@PatchMapping("/students")
	public void updateStudents(String name, int age){
		repository.updateStudent(name,age);
	}

	@DeleteMapping("/students")
	public void deleteStudents(String name){
		repository.deleteStudent(name);
	}






}
