
import java.util.Scanner;

public class arrayofobjects
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        student[] st;
        st = new student[n];
        for(int i=0;i<st.length;i++)
        {

            System.out.println("enter mark:" + (i+1) + " ");
            int m1 = s.nextInt();
            int m2 = s.nextInt();
            int m3 = s.nextInt();
            int m4 = s.nextInt();
            int m5 = s.nextInt();
            st[i] = new student();
            st[i] = new student(m1,m2,m3,m4,m5);
            st[i].display();
        }

        s.close();


    }
}

class student {
    int m1, m2, m3, m4, m5, tot, avg;

    student(int m1, int m2, int m3, int m4, int m5) {
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;

    }

    public student() {

    }

    public void display() {
        tot = m1 + m2 + m3 + m4 + m5;
        avg = tot / 5;
        System.out.println(avg);

    }
}