package JDBCconnect.config;

public enum EConfig {
    HOSTNAME("localhost"), PORT("3306"),DBNAME("project"), INTEGRATED_SECURITY("false"),
    USERNAME("root"), PASSWORD("admin");

    private final String DTB;


    private EConfig(String option) {
        this.DTB = option;
    }

    public String getDTB() {
        return this.DTB;
    }
}
