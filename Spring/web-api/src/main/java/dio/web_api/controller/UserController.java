package dio.web_api.controller;

import dio.web_api.model.Usuario;
import java.util.List;

import dio.web_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public List<Usuario> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }

    @PostMapping()
    public void postUser(@RequestBody Usuario usuario) {
        userRepository.save(usuario);
    }

    @PutMapping
    public void putUser(@RequestBody Usuario usuario) {
        userRepository.save(usuario);
    }
}
