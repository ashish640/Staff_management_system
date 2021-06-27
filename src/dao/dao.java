  package dao;

import Connection.connection;
import Model.Classs;
import Model.salary;
import Model.staff;
import Model.task;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class dao {

    public boolean checkLogin(String user, String pass) throws SQLException {

        String sql;
        Connection con = null;
        sql = "select * from admin where ID =? and password=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = null;
        rs = ps.executeQuery();
        if (rs.next()) {
            if (user.equals(rs.getString("ID")) && pass.equals(rs.getString("Password"))) {
                return true;
            }
        }
        return false;
    }

    public int Addstaff(staff e) throws SQLException {
        String sql;
        Connection con = null;
        sql = "insert into staff   values  (?, ?, ?, ?, ?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, e.getStaff_id());
        ps.setInt(2, e.getClass_id());
        ps.setString(3, e.getName());
        ps.setString(4, e.getEmail());
        ps.setString(5, e.getMobile());
        ps.setString(6, e.getDegree());
        ps.setString(7, e.getDesignation());
        ps.setString(8, e.getAddress());
        ps.setString(9, e.getCity());
        ps.setString(10, e.getDOB());
        ps.setString(11, e.getGender());

        ResultSet rs = null;
        int n = 0;
        n = ps.executeUpdate();
        if (n != 0) {
            return e.getStaff_id();
        }

        return n;
    }

    public int Staff_Id_Increment() throws SQLException {
        String sql;
        Connection con = null;
        sql = "select max(Staff_id) from staff";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        int n = 100;
        if (rs.next()) {
            if (rs.getInt("max(Staff_id)") != 0) {//coulm name
                n = rs.getInt("max(Staff_id)");
            }//n=0

        }
        return n + 1;

    }

    public staff getstaff(int s_id) throws SQLException {
        String sql;
        Connection con = null;
        sql = "select*from staff where Staff_id=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        staff s = new staff();
        ps.setInt(1, s_id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            s.setStaff_id(rs.getInt("Staff_id"));
            s.setClass_id(rs.getInt("Class_id"));
            s.setName(rs.getString("Name"));
            s.setEmail(rs.getString("Email"));
            s.setMobile(rs.getString("Mobile"));
            s.setDegree(rs.getString("Degree"));
            s.setDesignation(rs.getString("Designation"));
            s.setAddress(rs.getString("Address"));
            s.setCity(rs.getString("City"));
            s.setDOB(rs.getString("DOB"));
            s.setGender(rs.getString("Gender"));
            return s;
        }

        return null;
    }

    public int Deletestaff(int s_id) throws SQLException {
        String sql;
        Connection con = null;
        sql = "delete from staff where Staff_id = ?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, s_id);
        int n = 0;
        n = ps.executeUpdate();
        return n;

    }

    public int AddClass(Classs e) throws SQLException 
    {
        String sql;
        Connection con = null;
        sql = "insert into class   values  (?, ?, ?, ?, ?,?)";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, e.getClass_id());
        ps.setString(2, e.getClass_Name());
        ps.setInt(3, e.getBasic_pay());
        ps.setInt(4, e.getTa());
        ps.setInt(5, e.getMa());
        ps.setInt(6, e.getRa());
        

        ResultSet rs = null;
        int n = 0;
        n = ps.executeUpdate();
        if (n != 0) {
            return e.getClass_id();
        }

        return n;
    }

    public int Class_Id_Increment() throws SQLException {
        String sql;
        Connection con = null;
        sql = "select max(Class_id) from class";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        int n = 1000;
        if (rs.next()) {
            if (rs.getInt("max(Class_id)") != 0) {
                n = rs.getInt("max(Class_id)");
            }

        }
        return n + 1;

    }
    
    public List<String> getAllClasses() throws SQLException {

        String sql;
        Connection con = null;
        sql = "select * from class";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        ResultSet rs = null;
        rs = ps.executeQuery();
        List<String> li=new ArrayList<String>();
        while(rs.next()) {
            li.add(rs.getString("Class_Name"));
            }
        
        return li;
    }
    
    public Classs getClasssByname(String Classname) throws SQLException {
        String sql;
        Connection con = null;
        sql = "select*from class where Class_Name=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        Classs s = new Classs();
        ps.setString(1, Classname);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            s.setClass_id(rs.getInt("Class_id"));
            s.setClass_Name(rs.getString("Class_Name"));
            s.setBasic_pay(rs.getInt("Basic_pay"));
            s.setTa(rs.getInt("ta"));
            s.setMa(rs.getInt("ma"));
            s.setRa(rs.getInt("ra"));
            //System.out.println("Hello"+ s.getBasic_pay());
            return s;
        }

        return null;
    }

    public Classs getClasssByid(int Classid) throws SQLException {
        String sql;
        Connection con = null;
        sql = "select*from class where Class_id=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        Classs s = new Classs();
        ps.setInt(1, Classid);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            s.setClass_id(rs.getInt("Class_id"));
            s.setClass_Name(rs.getString("Class_Name"));
            s.setBasic_pay(rs.getInt("Basic_pay"));
            s.setTa(rs.getInt("ta"));
            s.setMa(rs.getInt("ma"));
            s.setRa(rs.getInt("ra"));
            
            return s;
        }

        return null;
    }

    public int updatestaff(staff e) throws SQLException {
        String sql;
        Connection con = null;
        sql = "update staff set Class_id=?,Name=?,Email=?,Mobile=?,Degree=?,Designation=?,Address=?,City=? where Staff_id=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, e.getClass_id());
        ps.setString(2, e.getName());
        ps.setString(3, e.getEmail());
        ps.setString(4, e.getMobile());
        ps.setString(5, e.getDegree());
        ps.setString(6, e.getDesignation());
        ps.setString(7, e.getAddress());
        ps.setString(8, e.getCity());
//        ps.setString(9, e.getDOB());
//        ps.setString(10, e.getGender());
        ps.setInt(9, e.getStaff_id());

        //ResultSet rs = null;
        int n = 0;
        n = ps.executeUpdate();
        if (n != 0) {
            return e.getStaff_id();
        }

        return n;
    }
    public List<staff> getallstaffbyclass(int Class_id) throws SQLException {
        String sql;
        Connection con = null;
        sql = "select*from staff where Class_id=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, Class_id);
        List<staff> l2=new ArrayList<staff>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            staff s = new staff();
            s.setStaff_id(rs.getInt("Staff_id"));
            s.setClass_id(rs.getInt("Class_id"));
            s.setName(rs.getString("Name"));
            s.setEmail(rs.getString("Email"));
            s.setMobile(rs.getString("Mobile"));
            s.setDegree(rs.getString("Degree"));
            s.setDesignation(rs.getString("Designation"));
            s.setAddress(rs.getString("Address"));
            s.setCity(rs.getString("City"));
            s.setDOB(rs.getString("DOB"));
            s.setGender(rs.getString("Gender"));
            l2.add(s);
        }

        return l2;
    }
    
    public int updateclass(Classs e) throws SQLException {
        String sql;
        Connection con = null;
        sql = "update class set Class_Name=?,Basic_pay=?,ta=?,ma=?,ra=? where Class_id=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        ps.setString(1, e.getClass_Name());
        ps.setInt(2, e.getBasic_pay());
        ps.setInt(3, e.getTa());
        ps.setInt(4, e.getMa());
        ps.setInt(5, e.getRa());
        
//        
        ps.setInt(6, e.getClass_id());

        ResultSet rs = null;
        int n = 0;
        n = ps.executeUpdate();
        if (n != 0) {
            return e.getClass_id();
        }

        return n;
    }

public int AddSalary(salary e) throws SQLException 
    {
        String sql;
        Connection con = null;
        sql = "insert into salary   values  (?, ?, ?, ?, ?,?,?)";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, e.getS_id());
        ps.setInt(2, e.getStaff_id());
        ps.setString(3, e.getMonth());
        ps.setInt(4, e.getBasic_pay());
        ps.setInt(5, e.getTa());
        ps.setInt(6, e.getMa());
        ps.setInt(7, e.getRa());
        

        ResultSet rs = null;
        int n = 0;
        n = ps.executeUpdate();
        if (n != 0) {
            return e.getS_id();
        }

        return n;
    }

public boolean checkSalary(int staffid , String month) throws SQLException {

        String sql;
        Connection con = null;
        sql = "select * from salary where Staff_id =? and Month=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, staffid);
        ps.setString(2, month);
        ResultSet rs = null;
        rs = ps.executeQuery();
        if (rs.next()) {
            return true;
            }
        
        return false;
    }

 public int Salary_Id_Increment() throws SQLException {
        String sql;
        Connection con = null;
        sql = "select max(s_id) from salary";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        int n = 100000;
        if (rs.next()) {
            if (rs.getInt("max(s_id)") != 0) {
                n = rs.getInt("max(s_id)");
            }

        }
        return n + 1;

    }
 public List<staff> getallstaff() throws SQLException {
        String sql;
        Connection con = null;
        sql = "select*from staff";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        
        List<staff> l2=new ArrayList<staff>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            staff s = new staff();
            s.setStaff_id(rs.getInt("Staff_id"));
            s.setClass_id(rs.getInt("Class_id"));
            s.setName(rs.getString("Name"));
            s.setEmail(rs.getString("Email"));
            s.setMobile(rs.getString("Mobile"));
            s.setDegree(rs.getString("Degree"));
            s.setDesignation(rs.getString("Designation"));
            s.setAddress(rs.getString("Address"));
            s.setCity(rs.getString("City"));
            s.setDOB(rs.getString("DOB"));
            s.setGender(rs.getString("Gender"));
            l2.add(s);
        }

        return l2;
    }
  
  public List<salary> getallsalarybystaffid(int Staff_id) throws SQLException {
        String sql;
        Connection con = null;
        sql = "select*from salary where Staff_id=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, Staff_id);
        List<salary> l2=new ArrayList<salary>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            salary s = new salary();
            s.setS_id(rs.getInt("s_id"));
            s.setStaff_id(rs.getInt("Staff_id"));
            s.setMonth(rs.getString("Month"));
            s.setBasic_pay(rs.getInt("Basic_pay"));
            s.setTa(rs.getInt("ta"));
            s.setMa(rs.getInt("ma"));
            s.setRa(rs.getInt("ra"));
            
            
            l2.add(s);
        }

        return l2;
    }
  
  public int Addtask(task t) throws SQLException {
        String sql;
        Connection con = null;
        sql = "insert into task   values  (?, ?, now(), ?, ?,?,now())";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1,t.getTask_id());
        ps.setInt(2,t.getStaff_id());
        ps.setString(3, t.getTask_name());
        ps.setString(4, t.getTask_description());
        ps.setString(5, t.getTask_status());
        ResultSet rs = null;
        int n = 0;
        n = ps.executeUpdate();
        if (n != 0) {
            return t.getTask_id();
        }

        return n;
    }
  
  public int Task_Id_Increment() throws SQLException {
        String sql;
        Connection con = null;
        sql = "select max(Task_id) from task";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        int n = 30000;
        if (rs.next()) {
            if (rs.getInt("max(Task_id)") != 0) {
                n = rs.getInt("max(Task_id)");
            }

        }
        return n + 1;

    }
  
  public List<task> getalltaskbystaffid(int Staff_id) throws SQLException {
        String sql;
        Connection con = null;
        sql = "select*from task where Staff_id=? order by Task_status desc";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        ps.setInt(1, Staff_id);
        List<task> l2=new ArrayList<task>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            task t=new task();
            t.setTask_id(rs.getInt("Task_id"));
            t.setStaff_id(rs.getInt("Staff_id"));
            t.setAssign_date(rs.getString("Assign_date"));
            t.setTask_name(rs.getString("Task_name"));
            t.setTask_description(rs.getString("Task_description"));
            t.setTask_status(rs.getString("Task_status"));
            t.setLast_update_date(rs.getString("Last_update_date"));
            l2.add(t);
        }

        return l2;
    }
    
public int updateTaskStatus(int taskid,String status) throws SQLException {
        String sql;
        Connection con = null;
        sql = "update task set Task_status=?,Last_update_date=now() where Task_id=?";
        PreparedStatement ps = null;
        con = connection.getConnection();
        ps = con.prepareStatement(sql);
        
        ps.setString(1, status);
        ps.setInt(2, taskid);
        

        ResultSet rs = null;
        int n = 0;
        n = ps.executeUpdate();
        if (n != 0) {
            return taskid;
        }

        return n;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(new dao().Staff_Id_Increment());
    }
}
