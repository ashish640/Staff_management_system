
package staff.management.system;

import view.Splash;
import view.FrontPage;
import view.Userint;

/**
 *
 * @author HP
 */
public class STAFFMANAGEMENTSYSTEM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Splash s = new Splash();
        s.setVisible(true);
                try
                {
        for(int i = 0; i <= 100 ; i++)
        {
            //System.out.print(i);
        Thread.sleep(100);
        //s.l1.setText(Integer.toString(i)+"%");
        s.jb.setValue(i);
            if(i == 100)
            {
                s.setVisible(false);
            new FrontPage();
       
            }
        }
        }catch(Exception c)
        {
        System.out.print(c);
        }
   
       //new Userint().setVisible(true);
    }
    
}
