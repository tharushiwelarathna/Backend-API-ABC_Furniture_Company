package lk.abc.service;

import lk.abc.dto.AdminDTO;

import java.util.ArrayList;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
public interface AdminService {
    void addAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    AdminDTO searchAdmin(String id);

    ArrayList<AdminDTO> getAllAdmin();

    void updateAdmin(AdminDTO dto);
}
