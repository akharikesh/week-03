import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; 
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMediaNetwork {
    private UserNode head;

    public SocialMediaNetwork() {
        head = null;
    }

    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
        System.out.println("User " + name + " added to the network.");
    }

    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) {
                user1.friendIds.add(userId2);
                System.out.println("User " + user1.name + " added " + user2.name + " as a friend.");
            }
            if (!user2.friendIds.contains(userId1)) {
                user2.friendIds.add(userId1);
                System.out.println("User " + user2.name + " added " + user1.name + " as a friend.");
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            if (user1.friendIds.remove((Integer) userId2)) {
                System.out.println("User " + user1.name + " removed " + user2.name + " from friends.");
            }
            if (user2.friendIds.remove((Integer) userId1)) {
                System.out.println("User " + user2.name + " removed " + user1.name + " from friends.");
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>();
            for (Integer friendId1 : user1.friendIds) {
                if (user2.friendIds.contains(friendId1)) {
                    mutualFriends.add(friendId1);
                }
            }

            if (mutualFriends.isEmpty()) {
                System.out.println("No mutual friends found.");
            } else {
                System.out.print("Mutual Friends: ");
                for (Integer friendId : mutualFriends) {
                    System.out.print(friendId + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + ": ");
            for (Integer friendId : user.friendIds) {
                System.out.println("Friend ID: " + friendId);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public UserNode findUserById(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public UserNode findUserByName(String name) {
        UserNode current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    
    public void countFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }
}

public class socialmedia {
    public static void main(String[] args) {
        SocialMediaNetwork network = new SocialMediaNetwork();
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 27);
        network.addUser(3, "Charlie", 24);
        network.addUser(4, "David", 22);

        
        network.addFriend(1, 2); 
        network.addFriend(1, 3);
        network.addFriend(2, 3); 
        network.addFriend(3, 4); 

        network.displayFriends(1);

        network.findMutualFriends(1, 2);

        network.removeFriend(1, 2); 

        network.countFriends(2);

        UserNode user = network.findUserByName("Charlie");
        if (user != null) {
            System.out.println("User found: " + user.name + ", Age: " + user.age);
        } else {
            System.out.println("User not found.");
        }
    }
}
