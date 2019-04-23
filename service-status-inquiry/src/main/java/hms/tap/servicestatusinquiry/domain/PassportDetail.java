package hms.tap.servicestatusinquiry.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class PassportDetail {
    private String refNo;
    private Date createDate;
    private Date lastUpdateDate;
    private String fullName;
    private String address;
    private String nic;
    private String status;

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static PassportDetail empty() {
        return new PassportDetail();
    }

    public String lastUpdateDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        return df.format(date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PassportDetail{");
        sb.append("refNo='").append(refNo).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateDate=").append(lastUpdateDate);
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", nic='").append(nic).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
