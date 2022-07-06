package day02;

public class Homework {
    /**
     * day2作业:
     * 一. 定义Norker类,
     * 包含String name, Stringjob(岗位),int salary(工资);
     * a属性私有,getset公开+全屈性构造+toString
     * b增加方法
     * /工作了months个月,返回总的工资
     * public int doJob(int months) {
     * sout("xx工作了xx个月,获得ox工资");
     * return总工资;
     * c在main中创建1个Worker)对象, 调用doJob方法.
     * 二. 定义SuperWorker类, 派生于Worker类, 增加float bonus成员变量 / 奖金系数, 范围在[O,]之间
     * 重写父类的doJob方法, 返回:总工资 = 普通工人总工资 * (1 + 奖金系数)
     * 同时重载doJob方法塔加入参addtionalHours(加班总工时), 即
     * public int doJob ( int months, int addtionalHours){
     * //返回不带加班时间的doJob返回值 + bonus * salary * addtionalHours / 100
     * ]
     * 在main中创建1个SuperWorker对象, 调用两个doJob方法
     */
    static class Worker {
        private final String name;
        private final String job;
        private final int salary;//月薪

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
            System.out.print("\n"+job+"\t"+name + "工作了" + months + "个月，获得" + months * salary + "工资");
            return months * salary;
        }
    }

    static class SuperWorker extends Worker {
        private float bonus=0.9f;//奖金系数0-1

        public int doJob(int months, int addtionalHours) {
//            System.out.println( (super.doJob(months) +bonus*getSalary()*addtionalHours/100));
            return (int) (super.doJob(months) +bonus*getSalary()*addtionalHours/100);
        }

        public SuperWorker(String name, String job, int salary) {
            super(name, job, salary);

        }
    }

    public static void main(String[] args) {

        Worker worker = new Worker("张三", "c开发工程师", 3500);
        worker.doJob(12);
        SuperWorker superWorker = new SuperWorker("李四","测试工程师",3500);
        System.out.println("，算上奖金后总工资为："+superWorker.doJob(12, 124));
    }
}
