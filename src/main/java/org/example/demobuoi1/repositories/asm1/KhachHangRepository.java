//package org.example.demobuoi1.repositories.asm1;
//
//import org.example.demobuoi1.entities.KhachHang;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//@Repository
//public class KhachHangRepository {
//    private List<KhachHang> ds;
//
//    public KhachHangRepository() {
//        ds = new ArrayList<>();
//        ds.add(new KhachHang(1,"Ph1","Thanh Hien","0395865069",1));
//        ds.add(new KhachHang(2,"Ph2","Thanh Hhoa","0395865069",0));
//        ds.add(new KhachHang(3,"Ph3","Khanh Thy", "0349120110",1));
//        ds.add(new KhachHang(4,"Ph4","An Ly", "0349120110",1));
//
//    }
//
//    public List<KhachHang> getAll(){
//        return this.ds;
//    }
//
//    public Page<KhachHang> findAllPage(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, ds.size());
//        List<KhachHang> pageContent = ds.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, ds.size());
//    }
//
//    public void create(KhachHang khachHang){
//        khachHang.setId(this.ds.size() + 1);
//        this.ds.add(khachHang);
//    }
//
//    public void deleteById(int id){
//        for (int i = 0; i < this.ds.size(); i++){
//            KhachHang kh = this.ds.get(i);
//            if (kh.getId() == id){
//                this.ds.remove(i);
//                break;
//            }
//        }
//    }
//
//    public KhachHang findById(int id){
//        for (int i = 0; i < this.ds.size(); i++){
//            KhachHang kh = this.ds.get(i);
//            if (kh.getId() == id){
//                return kh;
//            }
//        }
//        return null;
//    }
//
//    public KhachHang findByName(String ten) {
//        for (int i = 0; i < this.ds.size(); i++) {
//            KhachHang khachHang = this.ds.get(i);
//            if (khachHang.getTen().equals(ten)) {
//                return khachHang;
//            }
//        }
//        return null;
//    }
//
//    public void update(KhachHang khachHang){
//        for (int i = 0; i < this.ds.size(); i++){
//            KhachHang kh = this.ds.get(i);
//            if (kh.getId() == khachHang.getId()){
//                this.ds.set(i, khachHang);
//                break;
//            }
//        }
//    }
//
//    public  boolean exitByMa(String ma){
//        return ds.stream().anyMatch(sp -> sp.getMa().equals(ma));
//    }
//
//    public List<KhachHang> findByMaVaStatus(String valueSearch, Integer status) {
//        List<KhachHang> listKhachHang = new ArrayList<>();
//        if (ds == null) {
//            return listKhachHang;
//        }
//
//        boolean hasValueSearch = valueSearch != null && !valueSearch.isEmpty();
//        boolean hasStatus = status != null;
//
//        for (KhachHang khachHang : ds) {
//            boolean tenMatches = hasValueSearch && valueSearch.equalsIgnoreCase(khachHang.getTen());
//            boolean maMatches = hasValueSearch && valueSearch.equalsIgnoreCase(khachHang.getMa());
//            boolean sdtMatches = hasValueSearch && valueSearch.equalsIgnoreCase(khachHang.getSdt());
//            boolean statusMatches = hasStatus && status.equals(khachHang.getTrangThai());
//
//            if ((hasValueSearch && (maMatches || tenMatches || sdtMatches)) || (hasStatus && statusMatches)) {
//                if ((hasValueSearch && !(maMatches || tenMatches || sdtMatches)) || (hasStatus && !statusMatches)) {
//                    continue;
//                }
//                listKhachHang.add(khachHang);
//            }
//        }
//
//        return listKhachHang;
//    }
//
//}
