/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package akademiweb;

public class kelas {
    private int kodeKelas;
    private String namaKelas;
    private String jurusan;

    public kelas(int kodeKelas, String namaKelas, String jurusan) {
        this.kodeKelas = kodeKelas;
        this.namaKelas = namaKelas;
        this.jurusan = jurusan;
    }

    public int getKodeKelas() {
        return kodeKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public String getJurusan() {
        return jurusan;
    }
}

