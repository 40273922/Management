package test.service;

import factory.Factory;
import lombok.extern.slf4j.Slf4j;
import model.Stu;
import org.junit.jupiter.api.Test;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Zhai Jinpei
 */
@Slf4j
public class AdminServiceTest{
    {
        Scanner scanner = new Scanner(System.in);
        log.info("setDatabase_name");
        JDBCUtils.setDatabase_name(scanner.next());
        log.info("setUsername");
        JDBCUtils.setUsername(scanner.next());
        log.info("setPassword");
        JDBCUtils.setPassword(scanner.next());
        scanner.close();
    }

    @Test
    public void selectAllStu() throws SQLException{
        Object[][] objects = Factory.Serv().selectAllStu(new Stu("","","",""));
        for(Object[] objects1: objects){
            for(Object o: objects1) System.out.print(o + " ");
            System.out.println();
        }
    }

    @Test
    public void selectAllStuAllScore() throws SQLException{
        Object[][] objects1 = Factory.adminImpl().select("select score from s_c where sno = '2205221123'");
        double c = 0;
        for(Object[] objects2: objects1){
            c += (double)objects2[0];
        }
        System.out.println(c);
    }
}
