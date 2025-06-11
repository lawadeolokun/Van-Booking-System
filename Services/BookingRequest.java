package Services;

import java.util.Date;

public class BookingRequest {
    private ServiceType serviceType;
    private Date preferredDate;
    private Van assignedVan;

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Date getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(Date preferredDate) {
        this.preferredDate = preferredDate;
    }

    public Van getAssignedVan() {
        return assignedVan;
    }

    public void setAssignedVan(Van assignedVan) {
        this.assignedVan = assignedVan;
    }

    @Override
    public String toString() {
        return "Service: " + serviceType + ", Date: " + preferredDate;
    }
}
