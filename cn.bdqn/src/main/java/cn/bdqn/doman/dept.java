package cn.bdqn.doman;

public class dept {


        // 部门id
        private Integer id;

        // 部门名称
        private String deptName;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

    @Override
    public String toString() {
        return "dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
