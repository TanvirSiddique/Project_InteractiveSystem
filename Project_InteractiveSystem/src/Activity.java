public class Activity implements Comparable<Activity> {
    String name;
    int noOfTickets;

    public Activity (String name, int noOfTickets) {
        //setting the intput parameter if we put:fullname
        //name = fullName;
        this.name = name;
        this.noOfTickets = noOfTickets;
    }

    public void setName(String name) {
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public int getTickets() {
        return noOfTickets;
    }

    public int compareTo(Activity activity) {
        return this.name.compareTo(activity.name);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", noOfTickets=" + noOfTickets +
                '}';
    }
}
