/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class koneksi {
    private String databaseName = "ridhojnuar2210010522";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost/" + databaseName;
    private static Connection koneksiDB;

    public koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            System.out.println("Database Terkoneksi");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    // Tabel guru
    public void simpanguru(int guruNIP, String gurunama, String gurupendidikan, String gurujeniskelamin, String gurualamat) {
        try {
            String SQL = "INSERT INTO guru (NIP, Nama, Pendidikan, JenisKelamin, Alamat) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, guruNIP);
            perintah.setString(2, gurunama);
            perintah.setString(3, gurupendidikan);
            perintah.setString(4, gurujeniskelamin);
            perintah.setString(5, gurualamat);
            perintah.executeUpdate();
            System.out.println("Data guru berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk mengubah data guru
    public void ubahguru(int guruid, int guruNIP, String gurunama, String gurupendidikan, String gurujeniskelamin, String gurualamat) {
        try {
            String SQL = "UPDATE guru SET NIP=?, Nama=?, Pendidikan=?, JenisKelamin=?, Alamat=? WHERE id_guru=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, guruNIP);
            perintah.setString(2, gurunama);
            perintah.setString(3, gurupendidikan);
            perintah.setString(4, gurujeniskelamin);
            perintah.setString(5, gurualamat);
            perintah.setInt(6, guruid);
            perintah.executeUpdate();
            System.out.println("Data guru berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk menghapus data guru
    public void hapusguru(int guruid) {
        try {
            String SQL = "DELETE FROM guru WHERE id_guru=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, guruid);
            perintah.executeUpdate();
            System.out.println("Data guru berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    // Tabel kelas
    public void simpankelas(int kelasid, String kelasnama, String kelasjurusan) {
        try {
            String SQL = "INSERT INTO kelas (id_kelas, nama, jurusan) VALUES (?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, kelasid);
            perintah.setString(2, kelasnama);
            perintah.setString(3, kelasjurusan);
            perintah.executeUpdate();
            System.out.println("Data kelas berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk mengubah data kelas
    public void ubahkelas(int kelasid, String kelasnama, String kelasjurusan) {
        try {
            String SQL = "UPDATE kelas SET nama=?, jurusan=? WHERE id_kelas=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, kelasnama);
            perintah.setString(2, kelasjurusan);
            perintah.setInt(3, kelasid);
            perintah.executeUpdate();
            System.out.println("Data kelas berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk menghapus data kelas
    public void hapuskelas(int kelasid) {
        try {
            String SQL = "DELETE FROM kelas WHERE id_kelas=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, kelasid);
            perintah.executeUpdate();
            System.out.println("Data kelas berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Tabel mata pelajaran
    public void simpanmatapelajaran(int mapelid, String mapelnama) {
        try {
            String SQL = "INSERT INTO mata_pelajaran (id_mapel, nama) VALUES (?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, mapelid);
            perintah.setString(2, mapelnama);
            perintah.executeUpdate();
            System.out.println("Data mata pelajaran berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk mengubah data mata pelajaran
    public void ubahmatapelajaran(int mapelid, String mapelnama) {
        try {
            String SQL = "UPDATE mata_pelajaran SET nama=? WHERE id_mapel=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, mapelnama);
            perintah.setInt(2, mapelid);
            perintah.executeUpdate();
            System.out.println("Data mata pelajaran berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk menghapus data mata pelajaran
    public void hapusmatapelajaran(int mapelid) {
        try {
            String SQL = "DELETE FROM mata_pelajaran WHERE id_mapel=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, mapelid);
            perintah.executeUpdate();
            System.out.println("Data mata pelajaran berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }


    // Tabel siswa
    public void simpansiswa(int siswaNIS, String siswanama, String siswatempattanggallahir, String siswajeniskelamin, String siswaalamat, String siswatelp) {
        try {
            String SQL = "INSERT INTO siswa (NIS, nama, tempat_tanggal_lahir, jenis_kelamin, alamat, telp) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, siswaNIS);
            perintah.setString(2, siswanama);
            perintah.setString(3, siswatempattanggallahir);
            perintah.setString(4, siswajeniskelamin);
            perintah.setString(5, siswaalamat);
            perintah.setString(6, siswatelp);
            perintah.executeUpdate();
            System.out.println("Data siswa berhasil disimpan");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk mengubah data siswa
    public void ubahsiswa(int siswaid, int siswaNIS, String siswanama, String siswatempattanggallahir, String siswajeniskelamin, String siswaalamat, String siswatelp) {
        try {
            String SQL = "UPDATE siswa SET NIS=?, nama=?, tempat_tanggal_lahir=?, jenis_kelamin=?, alamat=?, telp=? WHERE id_siswa=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, siswaNIS);
            perintah.setString(2, siswanama);
            perintah.setString(3, siswatempattanggallahir);
            perintah.setString(4, siswajeniskelamin);
            perintah.setString(5, siswaalamat);
            perintah.setString(6, siswatelp);
            perintah.setInt(7, siswaid);
            perintah.executeUpdate();
            System.out.println("Data siswa berhasil diubah");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Metode untuk menghapus data siswa
    public void hapussiswa(int siswaid) {
        try {
            String SQL = "DELETE FROM siswa WHERE id_siswa=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, siswaid);
            perintah.executeUpdate();
            System.out.println("Data siswa berhasil dihapus");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}