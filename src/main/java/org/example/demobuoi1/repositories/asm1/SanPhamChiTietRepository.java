//package org.example.demobuoi1.repositories.asm1;
//
//
//import org.example.demobuoi1.entities.SanPhamChiTiet;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class SanPhamChiTietRepository {
//    private List<SanPhamChiTiet> ds;
//
//    public SanPhamChiTietRepository() {
//        ds = new ArrayList<>();
//        ds.add(new SanPhamChiTiet(1, 1, 1, 1, "SP1", 10, 200.000, 0));
//        ds.add(new SanPhamChiTiet(2, 2, 2, 2, "SP2", 20, 2400.000, 1));
//        ds.add(new SanPhamChiTiet(3, 3, 3, 3, "SP3", 30, 2700.000, 0));
//        ds.add(new SanPhamChiTiet(4, 4, 4, 4, "SP4", 40, 2800.000, 1));
//        ds.add(new SanPhamChiTiet(5, 5, 5, 5, "SP5", 50, 3000.000, 0));
//    }
//
//    public List<SanPhamChiTiet> getAll() {
//        return ds;
//    }
//
//    public Page<SanPhamChiTiet> findAllPage(Pageable pageable) {
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int startIndex = pageNumber * pageSize;
//        int endIndex = Math.min(startIndex + pageSize, ds.size());
//        List<SanPhamChiTiet> pageContent = ds.subList(startIndex, endIndex);
//        return new PageImpl<>(pageContent, pageable, ds.size());
//    }
//
//    public void create(SanPhamChiTiet sanPhamChiTiet) {
//        sanPhamChiTiet.setId(this.ds.size() + 1);
//        ds.add(sanPhamChiTiet);
//    }
//
//    public SanPhamChiTiet findById(int id) {
//        for (SanPhamChiTiet sanPhamChiTiet : ds) {
//            if (sanPhamChiTiet.getId() == id) {
//                return sanPhamChiTiet;
//            }
//        }
//        return null;
//    }
//
//    public List<SanPhamChiTiet> findBySanPhamId(int idSanPham) {
//        List<SanPhamChiTiet> ketQua = new ArrayList<>();
//        for (SanPhamChiTiet sanPhamChiTiet : ds) {
//            if (sanPhamChiTiet.getIdSanPham() == idSanPham) {
//                ketQua.add(sanPhamChiTiet);
//            }
//        }
//        return ketQua;
//    }
//
//    public void deleteById(int id) {
//        for (int i = 0; i < this.ds.size(); i++) {
//            SanPhamChiTiet sanPhamChiTiet = this.ds.get(i);
//            if (sanPhamChiTiet.getId() == id) {
//                this.ds.remove(i);
//                break;
//            }
//        }
//    }
//
//
//    public void update(SanPhamChiTiet sanPhamChiTiet) {
//        for (int i = 0; i < this.ds.size(); i++) {
//            SanPhamChiTiet sp = this.ds.get(i);
//            if (sp.getId() == sanPhamChiTiet.getId()) {
//                this.ds.set(i, sanPhamChiTiet);
//                break;
//            }
//        }
//    }
//
//    public boolean exitByMa(String ma) {
//        return ds.stream().anyMatch(sp -> sp.getMaSPCT().equals(ma));
//    }
//
//}
