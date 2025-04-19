package iteratorDesign;

public class CheckIterator {
    public  static void main(String[] args ){
        UserManagment user = new UserManagment();
        User user1 = new User("user1", 1);
        User user2 = new User("user2", 2);
        User user3 = new User("user3", 3);
        User user4 = new User("user4", 4);
        user.addUser(user1);
        user.addUser(user2);
        user.addUser(user3);
        user.addUser(user4);

        CustomIterator citerator = user.getIterator();
        while (citerator.hasNext()){
            System.out.println(citerator.next());
        }
    }
}
