package shared;

import java.io.Serializable;

/**
 * Implementere serializable med private værdier
 */
public class UserDTO implements Serializable {
	
	private int id;
    private String cbsMail, password, type;

	private static final long serialVersionUID = 1L;

    /**
     * getter og setters til UserDTO
     */
    public UserDTO(int id, String cbsMail, String password, String type) {
        this.id = id;
        this.cbsMail = cbsMail;
        this.password = password;
        this.type = type;
    }

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCbsMail() {
        return cbsMail;
    }

    public void setCbsMail(String cbsMail) {
        this.cbsMail = cbsMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
