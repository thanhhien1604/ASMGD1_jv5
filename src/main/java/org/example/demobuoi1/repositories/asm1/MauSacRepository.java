//package org.example.demobuoi1.repositories.asm1;
//
//import org.example.demobuoi1.entities.MauSac;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//@Repository
//public class MauSacRepository {
//    private List<MauSac> ds;
//
//    public MauSacRepository() {
//        ds = new ArrayList<MauSac>();
//        ds.add(new MauSac(1, "MS1","Vàng",0));
//        ds.add(new MauSac(2, "MS2","Đỏ",1));
//        ds.add(new MauSac(3, "MS3","Xanh",1));
//        ds.add(new MauSac(4, "MS4","Trắng",1));
//        ds.add(new MauSac(5, "MS5","Cam",1));
//        ds.add(new MauSac(6, "MS6","Tím",1));
//    }
//
//    public List<MauSac> getAll(){
//        return this.ds;
//    }
//
//    public Page<MauSac> findAllPage(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, ds.size());
//        List<MauSac> pageContent = ds.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, ds.size());
//    }
//
//    public Page<MauSac> findByNameContaining(String keyword, Pageable pageable) {
//        List<MauSac> filteredList = ds.stream()
//                .filter(mauSac -> mauSac.getTen().toLowerCase().contains(keyword.toLowerCase())
//                        || mauSac.getMa().toLowerCase().contains(keyword.toLowerCase()))
//                .collect(Collectors.toList());
//
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, filteredList.size());
//        List<MauSac> pageContent = filteredList.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, filteredList.size());
//    }
//
//    public void create(MauSac mauSac){
//        mauSac.setId(this.ds.size() + 1);
//        this.ds.add(mauSac);
//    }
//
//    public void deleteById(int id){
//        for (int i = 0; i < this.ds.size(); i++){
//            MauSac ms = this.ds.get(i);
//            if (ms.getId() == id){
//                this.ds.remove(i);
//                break;
//            }
//        }
//    }
//
//    public MauSac findById(int id){
//        for (MauSac mauSac : ds) {
//            if (mauSac.getId() == id) {
//                return mauSac;
//            }
//        }
//        return null;
//
//    }
//
//    public void update(MauSac mauSac){
//        for (int i = 0; i < this.ds.size(); i++){
//            MauSac ms = this.ds.get(i);
//            if (ms.getId() == mauSac.getId()){
//                this.ds.set(i, mauSac);
//                break;
//            }
//        }
//    }
//
//    public  boolean exitByMa(String ma){
//        return ds.stream().anyMatch(sp -> sp.getMa().equals(ma));
//    }
//
//    public List<MauSac> findByMaVaStatus(String valueSearch, Integer status) {
//        List<MauSac> listMauSac = new ArrayList<>();
//        if (ds == null) {
//            return listMauSac;
//        }
//
//        boolean hasValueSearch = valueSearch != null && !valueSearch.isEmpty();
//        boolean hasStatus = status != null;
//
//        for (MauSac mauSac : ds) {
//            boolean maMatches = hasValueSearch && valueSearch.equalsIgnoreCase(mauSac.getMa());
//            boolean tenMatches = hasValueSearch && valueSearch.equalsIgnoreCase(mauSac.getTen());
//            boolean statusMatches = hasStatus && status.equals(mauSac.getTrangThai());
//
//            if ((hasValueSearch && (maMatches || tenMatches)) || (hasStatus && statusMatches)) {
//                if ((hasValueSearch && !(maMatches || tenMatches)) || (hasStatus && !statusMatches)) {
//                    continue;
//                }
//                listMauSac.add(mauSac);
//            }
//        }
//
//        return listMauSac;
//    }
//}
