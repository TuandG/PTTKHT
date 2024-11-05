package com.example.libman.model;

import lombok.Data;

import java.util.Set;

@Data
public class BanDoc766 extends ThanhVien766{
    private Set<PhieuMuon766> phieuMuons;
    private Set<TheDocTrucTuyen766> theDocTrucTuyens;

    public Set<PhieuMuon766> getPhieuMuons() {
        return phieuMuons;
    }

    public void setPhieuMuons(Set<PhieuMuon766> phieuMuons) {
        this.phieuMuons = phieuMuons;
    }

    public Set<TheDocTrucTuyen766> getTheDocTrucTuyens() {
        return theDocTrucTuyens;
    }

    public void setTheDocTrucTuyens(Set<TheDocTrucTuyen766> theDocTrucTuyens) {
        this.theDocTrucTuyens = theDocTrucTuyens;
    }
}
