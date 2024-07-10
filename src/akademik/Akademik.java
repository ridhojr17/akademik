/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package akademik;

import crud.koneksi;
import java.util.Scanner;

public class Akademik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        koneksi db = new koneksi();

        // Input for Kelas
        System.out.println("====== KELAS ======");
        System.out.print("Masukkan Kode Kelas: ");
        int kodekelas = input.nextInt();
        input.nextLine();  // Consume newline

        System.out.print("Masukkan Nama Kelas: ");
        String namakelas = input.nextLine();

        System.out.print("Masukkan Jurusan: ");
        String jurusan = input.nextLine();

        // Simpan data kelas ke database
        db.simpankelas(kodekelas, namakelas, jurusan);

        // Input for Mata Pelajaran
        System.out.println("====== MATA PELAJARAN ======");
        System.out.print("Masukkan Kode Mata Pelajaran: ");
        int kodemapel = input.nextInt();
        input.nextLine();  // Consume newline

        System.out.print("Masukkan Nama Mata Pelajaran: ");
        String namamapel = input.nextLine();

        // Simpan data mata pelajaran ke database
        db.simpanmatapelajaran(kodemapel, namamapel);

 
    }
}
