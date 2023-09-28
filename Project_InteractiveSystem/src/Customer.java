public class Customer implements Comparable<Customer> {
        String firstName;
        String surName;
        SortedArrayList<Activity> activities;

        public Customer (String firstName, String surName) {
                this.firstName = firstName;
                this.surName = surName;

                activities = new SortedArrayList<Activity>();

        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setSurName( String surName) {
                this.surName = surName;
        }

        public String getSurName() {
                return surName;
        }

        public int compareTo(Customer customer) {
                //int sname = this.surName.compareTo(customer.surName);
                if(this.surName.compareTo(customer.surName) < 0 || this.surName.compareTo(customer.surName) > 0 ){
                        return this.surName.compareTo(customer.surName);
                }
                else {
                        return this.firstName.compareTo(customer.firstName);
                }
        }
  // 24/06/2023
  public void addActivity(Activity activity) {
        // check if activities.size() <= 3
        // check if activity exists in activities

        if (activities.size() == 0) {
                activities.add(activity);
        } else if (activities.size() < 3) {
                // boolean keeps track of whether activity already exist in activities
                // initial assumption is activity to be added doesn't exist in activities
                boolean exists = false;

                //  for each Activity named "a" inside of activities
                for (Activity a : activities) {
                        // activity.name similar to existing a.name
                        // compareTo method...how to use??
                        if (activity.getName().compareTo(a.name) == 0) {
                                // activity already exists
                                exists = true;

                                // check number of tickets the customer wants to buy
                                int newTickets = activity.getTickets();

                                // check number of tickets the customer owns
                                int oldTickets = a.getTickets();

                                // add more tickets
                                a.setTickets(oldTickets + newTickets);
                        }
                }

                // if (exists) ==> if (exists == true)
                // if (!exists) ==> if (exists == false)

                if (exists == false) {
                        // since activity doesn't exist yet, just add
                        activities.add(activity);
                        //Sorting the added activity inside activities using 'insertionSort() method'
                        activities.insertionSort();
                }
        } else if (activities.size() == 3) {
                //  for each Activity named "a" inside of activities
                for (Activity a : activities) {
                        // activity.name similar to existing a.name
                        // compareTo method...how to use??
                        if (activity.getName().compareTo(a.name) == 0) {

                                // check number of tickets the customer wants to buy
                                int newTickets = activity.getTickets();

                                // check number of tickets the customer owns
                                int oldTickets = a.getTickets();

                                // add more tickets
                                a.setTickets(oldTickets + newTickets);
                        }
                }
        }

  }

  public void removeActivity(Activity activity) {
        if (activities.size() > 0) {
               //for each Activity named "a" inside of activities
               for(Activity a: activities) {
                       //activity.name similar to existing a.name
                       //compareTo method...how to use??
                       if (activity.getName().compareTo(a.name) == 0) {
                               //check number of tickets the customer wants to remove
                               int newTickets = activity.getTickets();

                               //check number of tickets the customer already owns
                               int oldTickets = a.getTickets();

                               if (oldTickets >= newTickets) {
                                       //remove tickets
                                       a.setTickets(oldTickets - newTickets);
                               }
                       }

                       if (a.getTickets() == 0) {
                               activities.remove(a);
                       }

               }

        }

  }

  public SortedArrayList<Activity> getActivities() {
                return activities;
        }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", activities=" + activities +
                '}';
    }
}
