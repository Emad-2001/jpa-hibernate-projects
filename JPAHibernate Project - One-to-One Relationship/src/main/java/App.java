import entities.Post;
import entities.User;
import org.w3c.dom.ls.LSOutput;
import service.PostService;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class App {

      private static final UserService userService = new UserService();
      private static final PostService postService = new PostService();
      private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Create user");
            System.out.println("2. Read user by ID");
            System.out.println("3. Read all users");
            System.out.println("4. Update user");
            System.out.println("5. Delete user");
            System.out.println("6. Create post");
            System.out.println("7. Read post by ID");
            System.out.println("8. Read all posts");
            System.out.println("9. Update post");
            System.out.println("10. Delete post");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    readUser();
                    break;
                case 3:
                    readAllUsers();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 6:
                    createPost();
                    break;
                case 7:
                    readPost();
                    break;
                case 8:
                    readAllPosts();
                    break;
                case 9:
                    updatePost();
                    break;
                case 10:
                    deletePost();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void createUser() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        User user = new User(null, username, password, null);
        userService.create(user);
    }

    private static void readUser() {
        System.out.println("Enter user ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        User user = userService.read(id);
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("User not found.");
        }
    }

    private static void readAllUsers() {
        List<User> users = userService.readAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    private static void updateUser() {
        System.out.println("Enter user ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        User user = userService.read(id);
        System.out.println("user to modify : "+user);
        if (user != null) {
            System.out.println("Enter new username:");
            String name = scanner.nextLine();

            System.out.println("Enter new password:");
            String newPassword = scanner.nextLine();

            user.setName((name.isEmpty() == true)? user.getName() : name);
            user.setPassword((newPassword.isEmpty() == true)? user.getPassword() : newPassword);

            userService.update(user);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void deleteUser() {
        System.out.println("Enter user ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();

        userService.delete(id);
    }

//    ----------------------------- POST -----------------------------
    private static void createPost() {
        System.out.println("Enter user ID:");
        Long userId = scanner.nextLong();
        scanner.nextLine();

        User user = userService.read(userId);
        if(user != null){
            if(user.getPost() != null){
                System.out.println("this user already has a post !! (go to modify)");
                return;
            }
            System.out.println("Enter post title :");
            String postTitle = scanner.nextLine();
            System.out.println("Enter post Content :");
            String postContent = scanner.nextLine();

            user.setPost(new Post(null, postTitle, postContent));
            userService.update(user);
        }else {
            System.out.println("user Not found !!");
        }
    }

    private static void readPost(){
        System.out.println("Enter Post's ID:");
        Long postId = scanner.nextLong();

        Post post = postService.read(postId);
        if(post != null){
            System.out.println(post);
        }else{
            System.out.println("post not found !!");
        }

    }

    private  static void readAllPosts(){
        List<Post> posts = postService.readAll();
        posts.stream().forEach(p -> System.out.println(p));
    }

   private static void updatePost(){

   }

   private static void deletePost(){

   }

}
