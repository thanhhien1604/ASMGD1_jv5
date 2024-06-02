//package org.example.demobuoi1.repositories.asm1;
//
//import org.example.demobuoi1.entities.NhanVien;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class NhanVienRepository {
//    private List<NhanVien> ds;
//    public NhanVienRepository() {
//        ds = new ArrayList<>();
//        ds.add(new NhanVien(1, "Thanh Hien", "NV1", "hien@gmail.com","hien123", 1));
//        ds.add(new NhanVien(2, "Thanh Hoa", "NV2", "hoa@gmail.com","hoa123", 0));
//
//    }
//
//    public List<NhanVien> getAll() {
//        return ds;
//    }
//
//    public Page<NhanVien> findAllPage(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, ds.size());
//        List<NhanVien> pageContent = ds.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, ds.size());
//    }
//    public void create(NhanVien nhanVien) {
//        nhanVien.setId(this.ds.size() + 1);
//        ds.add(nhanVien);
//    }
//
//    public NhanVien deleteById(int id) {
//        for (NhanVien nhanVien : ds) {
//            if (nhanVien.getId() == id) {
//                ds.remove(nhanVien);
//                return nhanVien;
//            }
//        }
//        return null;
//    }
//
//    public NhanVien findById(int id) {
//        for (NhanVien nhanVien : ds) {
//            if (nhanVien.getId() == id) {
//                return nhanVien;
//            }
//        }
//        return null;
//    }
//
//    public NhanVien update(NhanVien nhanVien) {
//        for (NhanVien nhanVien1 : ds) {
//            if (nhanVien1.getId() == nhanVien.getId()) {
//                ds.remove(nhanVien1);
//                ds.add(nhanVien);
//                return nhanVien;
//            }
//        }
//        return null;
//    }
//
//      public NhanVien findByUsername(String username) {
//        for (int i = 0; i < ds.size(); i++) {
//            NhanVien nhanVien = ds.get(i);
//            if (nhanVien.getTenDangNhap().equals(username)) {
//                return nhanVien;
//            }
//        }
//        return null;
//    }
//
//    public NhanVien findByName(String ten) {
//        for (int i = 0; i < this.ds.size(); i++) {
//            NhanVien nhanVien = this.ds.get(i);
//            if (nhanVien.getTen().equals(ten) ) {
//                return nhanVien;
//            }
//        }
//        return null;
//    }
//
//    public  boolean exitByMa(String ma){
//        return ds.stream().anyMatch(sp -> sp.getMa().equals(ma));
//    }
//
//    public List<NhanVien> findByMaVaStatus(String valueSearch, Integer status) {
//        List<NhanVien> listNhanVien = new ArrayList<>();
//        if (ds == null) {
//            return listNhanVien;
//        }
//
//        boolean hasValueSearch = valueSearch != null && !valueSearch.isEmpty();
//        boolean hasStatus = status != null;
//
//        for (NhanVien nhanVien : ds) {
//            boolean maMatches = hasValueSearch && valueSearch.equalsIgnoreCase(nhanVien.getMa());
//            boolean tenMatches = hasValueSearch && valueSearch.equalsIgnoreCase(nhanVien.getTen());
//            boolean statusMatches = hasStatus && status.equals(nhanVien.getTrangThai());
//
//            if ((hasValueSearch && (maMatches || tenMatches)) || (hasStatus && statusMatches)) {
//                if ((hasValueSearch && !(maMatches || tenMatches)) || (hasStatus && !statusMatches)) {
//                    continue;
//                }
//                listNhanVien.add(nhanVien);
//            }
//        }
//
//        return listNhanVien;
//    }
//}
