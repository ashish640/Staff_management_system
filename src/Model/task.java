
package Model;


public class task {
    int Task_id,Staff_id;
    String Assign_date,Task_name,Task_description,Task_status,Last_update_date;

    public int getTask_id() {
        return Task_id;
    }

    public void setTask_id(int Task_id) {
        this.Task_id = Task_id;
    }

    public int getStaff_id() {
        return Staff_id;
    }

    public void setStaff_id(int Staff_id) {
        this.Staff_id = Staff_id;
    }

    public String getAssign_date() {
        return Assign_date;
    }

    public void setAssign_date(String Assign_date) {
        this.Assign_date = Assign_date;
    }

    public String getTask_name() {
        return Task_name;
    }

    public void setTask_name(String Task_name) {
        this.Task_name = Task_name;
    }

    public String getTask_description() {
        return Task_description;
    }

    public void setTask_description(String Task_description) {
        this.Task_description = Task_description;
    }

    public String getTask_status() {
        return Task_status;
    }

    public void setTask_status(String Task_status) {
        this.Task_status = Task_status;
    }

    public String getLast_update_date() {
        return Last_update_date;
    }

    public void setLast_update_date(String Last_update_date) {
        this.Last_update_date = Last_update_date;
    }
    
    
}
