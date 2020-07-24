package com.epam_task_design_patterns.Design_Patterns;

public class Builder_Pattern {

	public static void main(String[] args) {
		   User user1 = new User.UserBuilder("Sai", "Jyothi")
		   .age(20)
		   .address("Hyderabad")
		   .build();
		   System.out.println(user1);

		   User user2 = new User.UserBuilder("Akankshya", "Mohanty")
		   .age(22)
		   .address("Orissa")
		   .build();
		   System.out.println(user2);
		   
		   User user3 = new User.UserBuilder("Lekhana", "Edla")
		   .address("Palakkad")
		   .build();
	       System.out.println(user3);

		   User user4 = new User.UserBuilder("Sai", "Chandra")
		   .build();
	       System.out.println(user4);
		}

		}
		class User
		{
		    //All final attributes
		    private final String firstName; // required
		    private final String lastName; // required
		    private final int age; // optional
		    private final String phone; // optional
		    private final String address; // optional
		 
		    private User(UserBuilder builder) {
		        this.firstName = builder.firstName;
		        this.lastName = builder.lastName;
		        this.age = builder.age;
		        this.phone = builder.phone;
		        this.address = builder.address;
		    }
		 
		    public String getFirstName() {
		        return firstName;
		    }
		    public String getLastName() {
		        return lastName;
		    }
		    public int getAge() {
		        return age;
		    }
		    public String getPhone() {
		        return phone;
		    }
		    public String getAddress() {
		        return address;
		    }
		 
		    @Override
		    public String toString() {
		        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
		    }
		 
		    public static class UserBuilder
		    {
		        private final String firstName;
		        private final String lastName;
		        private int age;
		        private String phone;
		        private String address;
		 
		        public UserBuilder(String firstName, String lastName) {
		            this.firstName = firstName;
		            this.lastName = lastName;
		        }
		        public UserBuilder age(int age) {
		            this.age = age;
		            return this;
		        }
		        public UserBuilder phone(String phone) {
		            this.phone = phone;
		            return this;
		        }
		        public UserBuilder address(String address) {
		            this.address = address;
		            return this;
		        }
		        public User build() {
		            User user =  new User(this);
		            validateUserObject(user);
		            return user;
		        }
		        private void validateUserObject(User user) {
		           
		        }
		    }
		}
		
/*OUTPUT:
 User: Sai, Jyothi, 20, null, Hyderabad
User: Akankshya, Mohanty, 22, null, Orissa
User: Lekhana, Edla, 0, null, Palakkad
User: Sai, Chandra, 0, null, null
*/
