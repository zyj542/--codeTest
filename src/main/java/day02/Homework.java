package day02;

public class Homework {
    /**
     * day2��ҵ:
     * һ. ����Norker��,
     * ����String name, Stringjob(��λ),int salary(����);
     * a����˽��,getset����+ȫ���Թ���+toString
     * b���ӷ���
     * /������months����,�����ܵĹ���
     * public int doJob(int months) {
     * sout("xx������xx����,���ox����");
     * return�ܹ���;
     * c��main�д���1��Worker)����, ����doJob����.
     * ��. ����SuperWorker��, ������Worker��, ����float bonus��Ա���� / ����ϵ��, ��Χ��[O,]֮��
     * ��д�����doJob����, ����:�ܹ��� = ��ͨ�����ܹ��� * (1 + ����ϵ��)
     * ͬʱ����doJob�����������addtionalHours(�Ӱ��ܹ�ʱ), ��
     * public int doJob ( int months, int addtionalHours){
     * //���ز����Ӱ�ʱ���doJob����ֵ + bonus * salary * addtionalHours / 100
     * ]
     * ��main�д���1��SuperWorker����, ��������doJob����
     */
    static class Worker {
        private final String name;
        private final String job;
        private final int salary;//��н

        public Worker(String name, String job, int salary) {
            this.name = name;
            this.job = job;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getJob() {
            return job;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "name='" + name + '\'' +
                    ", job='" + job + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public float doJob(int months) {
            System.out.print("\n"+job+"\t"+name + "������" + months + "���£����" + months * salary + "����");
            return months * salary;
        }
    }

    static class SuperWorker extends Worker {
        private float bonus=0.9f;//����ϵ��0-1

        public int doJob(int months, int addtionalHours) {
//            System.out.println( (super.doJob(months) +bonus*getSalary()*addtionalHours/100));
            return (int) (super.doJob(months) +bonus*getSalary()*addtionalHours/100);
        }

        public SuperWorker(String name, String job, int salary) {
            super(name, job, salary);

        }
    }

    public static void main(String[] args) {

        Worker worker = new Worker("����", "c��������ʦ", 3500);
        worker.doJob(12);
        SuperWorker superWorker = new SuperWorker("����","���Թ���ʦ",3500);
        System.out.println("�����Ͻ�����ܹ���Ϊ��"+superWorker.doJob(12, 124));
    }
}
