//package org.example.demobuoi1.repositories.asm1;
//
//import org.apache.catalina.LifecycleState;
//import org.example.demobuoi1.entities.SanPham;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class SanPhamRepository {
//    private List<SanPham> ds;
//    public SanPhamRepository(){
//        this.ds = new ArrayList<>();
//        this.ds.add(new SanPham(1,"SP1", "Quan bo", 1));
//        this.ds.add(new SanPham(2,"SP2", "Ao ke", 0));
//        this.ds.add(new SanPham(3,"SP3", "Quan âu", 1));
//        this.ds.add(new SanPham(4,"SP4", "Quan jeans", 1));
//        this.ds.add(new SanPham(5,"SP5", "Váy", 1));
//    }
//
//    public List<SanPham> getAll(){
//        return this.ds;
//    }
//
//    public Page<SanPham> findAllPage(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, ds.size());
//        List<SanPham> pageContent = ds.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, ds.size());
//    }
//
//    public void create(SanPham sanPham){
//        sanPham.setId(this.ds.size() + 1);
//        ds.add(sanPham);
//    }
//
//    public void deleteById(int id){
//        for (int i = 0; i < this.ds.size(); i++){
//            SanPham sp = this.ds.get(i);
//            if (sp.getId() == id){
//                this.ds.remove(i);
//                break;
//            }
//        }
//    }
//
//    public SanPham findById(int id){
//        for (int i = 0; i < this.ds.size(); i++){
//            SanPham sp = this.ds.get(i);
//            if (sp.getId() == id){
//                return sp;
//            }
//        }
//        return null;
//    }
//
//    public void update(SanPham sanPham){
//        for (int i = 0; i < this.ds.size(); i++){
//            SanPham sp = this.ds.get(i);
//            if (sp.getId() == sanPham.getId()){
//                this.ds.set(i, sanPham);
//            }
//        }
//    }
//
//    public  boolean exitByMa(String ma){
//       return ds.stream().anyMatch(sp -> sp.getMa().equals(ma));
//    }
//
//    public List<SanPham> findByMaVaStatus(String valueSearch, Integer status) {
//        List<SanPham> listSanPham = new ArrayList<>();
//        if (ds == null) {
//            return listSanPham;
//        }
//
//        boolean hasValueSearch = valueSearch != null && !valueSearch.isEmpty();
//        boolean hasStatus = status != null;
//
//        for (SanPham sanPham : ds) {
//            boolean maMatches = hasValueSearch && valueSearch.equalsIgnoreCase(sanPham.getMa());
//            boolean tenMatches = hasValueSearch && valueSearch.equalsIgnoreCase(sanPham.getTen());
//            boolean statusMatches = hasStatus && status.equals(sanPham.getTrangThai());
//
//            if ((hasValueSearch && (maMatches || tenMatches)) || (hasStatus && statusMatches)) {
//                if ((hasValueSearch && !(maMatches || tenMatches)) || (hasStatus && !statusMatches)) {
//                    continue;
//                }
//                listSanPham.add(sanPham);
//            }
//        }
//
//        return listSanPham;
//    }
//
//}
