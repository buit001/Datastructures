package generatestudents;

/**
 *
 * @author breud
 */
public class GenerateStudents
{

    /**
     * @param args the command line arguments
     */
    public static final int[] HASHTABLESIZE =
    {
        10501, 11701, 13309, 15401
    };
    private static int[] collisionTable = new int[97];

    public static void main(String[] args)
    {

        StudentList students = new StudentList(10000);
        LinearProbing lpp = null;
        QuadraticProbing qpp = null;
        SeperateChaining spp = null;

        //Create hashes for the 97 size array
        hashFunction(students);
        printCollisionArray();
        for (int i : HASHTABLESIZE)
        {
            LinearProbing lp = new LinearProbing(i);
            QuadraticProbing qp = new QuadraticProbing(i);
            SeperateChaining sp = new SeperateChaining(i);

            for (Student stu : students.getList())
            {
                lp.put(stu.getLdap(), stu.getEcts());
                qp.put(stu.getLdap(), stu.getEcts());
                sp.put(stu.getLdap(), stu.getEcts());
            }

            System.out.println("Linear Probing with table size: " + i + " Collisions: " + lp.getCollisions());
            System.out.println("Quadratic Probing with table size: " + i + " Collisions: " + qp.getCollisions());
            System.out.println("Seperate Chaining with table size: " + i + " Collisions: " + sp.getCollisions());
            lpp = lp;
            qpp = qp;
            spp = sp;
        }
    }

    private static void hashFunction(StudentList students)
    {

        for (Student stu : students.getList())
        {
            int n = 0;
            int h = 0;
            long hash = 0;
            for (int i = 0; i < stu.getLdap().length(); i++)
            {
                hash = (hash << 5) - hash + stu.getLdap().charAt(i);
            }
                hash = hash % 97;
                collisionTable[(int)hash] += 1;
            }
        }

    

    private static void printCollisionArray()
    {
        for (int i = 0; i < collisionTable.length; i++)
        {
            System.out.println("[" + i + ", " + collisionTable[i] + "]");
        }
    }

}
