package com.dao;



import com.db.DBConnection;
import com.utility.Emp;

import java.util.*;
import java.sql.*;


public class EmpDao {

    DBConnection db =  new DBConnection();
    private Connection con = null;

    public static int save(Emp e){
        int status=0;
        try{
            Connection con = DBConnection.getConnection();
            String query = "insert into emp(name,email,salary,city) values (?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setInt(3,e.getSalary());
            ps.setString(4,e.getCity());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return status;
    }
    public static int update(Emp e){
        int status=0;
        try{
            Connection con=DBConnection.getConnection();
            String query = "update emp set name=?,email=?,salary=?,city=? where id=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setInt(3,e.getSalary());
            ps.setString(4,e.getCity());
            ps.setInt(5,e.getId());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection con=DBConnection.getConnection();
            String q = "delete from emp where id=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1,id);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }
    public static Emp getEmployeeById(int id){
        Emp e=new Emp();

        try{
            Connection con=DBConnection.getConnection();
            String query = "select * from emp where id=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setSalary(rs.getInt(4));
                e.setCity(rs.getString(5));
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return e;
    }
    public static List<Emp> getAllEmployees(){
        List<Emp> list=new ArrayList<Emp>();

        try{
            Connection con=DBConnection.getConnection();
            String q = "select * from emp";
            PreparedStatement ps=con.prepareStatement(q);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Emp e=new Emp();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setEmail(rs.getString(3));
                e.setSalary(rs.getInt(4));
                e.setCity(rs.getString(5));
                list.add(e);
            }
            con.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return list;
    }
}

