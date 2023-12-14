package org.example;

public class Decision {
    private String decisionType;
    private DecisionStatus status;
    //private String rejectionReason;

    public Decision(String decisionType) {
        this.decisionType = decisionType;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }
    public DecisionStatus getStatus() {
        return status;
    }

    public void setStatus(DecisionStatus status) {
        this.status = status;
    }

    /*public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }*/
    @Override
    public String toString() {
        return "Decision Type for the Transaction: " + decisionType;
    }
}

