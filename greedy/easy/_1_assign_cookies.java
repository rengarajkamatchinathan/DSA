public class _1_assign_cookies {
    public static void main(String[] args) {
        int[] Student = {1, 2} , Cookie = {1, 2, 3};
        // Output : 2
        int sid = 0, cid = 0;
        while (sid<Student.length && cid<Cookie.length) {
            if (Student[sid]<=Cookie[cid]) {
                sid++;
            }else{
                cid++;
            }
        }

        System.out.println(sid);
    }
}
