//package org.example.demobuoi1.repositories.asm1;
//
//import org.example.demobuoi1.entities.KichThuoc;
//import org.example.demobuoi1.entities.MauSac;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//@Repository
//public class KichThuocRepository {
//    private List<KichThuoc> ds;
//
//    public KichThuocRepository(){
//        ds = new ArrayList<>();
//        ds.add(new KichThuoc(1, "KT1", "M",1));
//        ds.add(new KichThuoc(2, "KT2", "L",1));
//        ds.add(new KichThuoc(3, "KT3", "XL",1));
//        ds.add(new KichThuoc(4, "KT4", "XXL",1));
//        ds.add(new KichThuoc(5, "KT5", "XXXL",0));
//
//    }
//
//    public List<KichThuoc> getAll() {
//        return ds;
//    }
//
//    public Page<KichThuoc> findAllPage(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, ds.size());
//        List<KichThuoc> pageContent = ds.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, ds.size());
//    }
//
//    public void create(KichThuoc kichThuoc) {
//        kichThuoc.setId(this.ds.size() + 1);
//        ds.add(kichThuoc);
//    }
//
//    public KichThuoc deleteById(int id) {
//        for (KichThuoc kichThuoc : ds){
//            if (kichThuoc.getId() == id){
//                ds.remove(kichThuoc);
//                return kichThuoc;
//            }
//        }
//        return null;
//    }
//
//    public KichThuoc findById(int id) {
//        for (KichThuoc kichThuoc : ds){
//            if (kichThuoc.getId() == id){
//                return kichThuoc;
//            }
//        }
//        return null;
//    }
//
//    public void update(KichThuoc kichThuoc) {
//         for (KichThuoc kichThuoc1 : ds){
//            if (kichThuoc1.getId() == kichThuoc.getId()){
//                ds.remove(kichThuoc1);
//                ds.add(kichThuoc);
//                break;
//            }
//        }
//    }
//
//    public  boolean exitByMa(String ma){
//        return ds.stream().anyMatch(sp -> sp.getMa().equals(ma));
//    }
//
//    public List<KichThuoc> findByMaVaStatus(String valueSearch, Integer status) {
//        List<KichThuoc> listKichThuoc = new ArrayList<>();
//        if (ds == null) {
//            return listKichThuoc;
//        }
//
//        boolean hasValueSearch = valueSearch != null && !valueSearch.isEmpty();
//        boolean hasStatus = status != null;
//
//        for (KichThuoc kichThuoc : ds) {
//            boolean maMatches = hasValueSearch && valueSearch.equalsIgnoreCase(kichThuoc.getMa());
//            boolean tenMatches = hasValueSearch && valueSearch.equalsIgnoreCase(kichThuoc.getTen());
//            boolean statusMatches = hasStatus && status.equals(kichThuoc.getTrangThai());
//
//            if ((hasValueSearch && (maMatches || tenMatches)) || (hasStatus && statusMatches)) {
//                if ((hasValueSearch && !(maMatches || tenMatches)) || (hasStatus && !statusMatches)) {
//                    continue;
//                }
//                listKichThuoc.add(kichThuoc);
//            }
//        }
//
//        return listKichThuoc;
//    }
//}
