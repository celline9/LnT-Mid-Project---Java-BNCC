import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class main {
	Scanner scan = new Scanner(System.in);	
	Random rand = new Random();
	ArrayList <String> kodelist = new ArrayList<>();
	ArrayList <String> genderlist = new ArrayList<>();
	ArrayList <String> namalist = new ArrayList<>();
	ArrayList <String> jabatanlist = new ArrayList<>();
	ArrayList <Integer> gajilist = new ArrayList<>();
	
	
	String nama="", gender="", jabatan="";
	int gaji=0;
	
	public main() {
	int menu = 0;
		while(true) {
			try {
				System.out.println("PT ChipiChapa");
				System.out.println("==============");
				System.out.println("1. Insert data karyawan");
				System.out.println("2. View data karyawan");
				System.out.println("3. Update data karyawan");
				System.out.println("4. Delete data karyawan");
				System.out.println("5. Exit");
				menu = scan.nextInt();scan.nextLine();
			} catch (Exception e) {
				System.out.println("Something went wrong");
				scan.nextLine();
			}
		
		
		switch (menu) {
		case 1:
			insert();
			break;
		case 2:
			view();
			break;
		case 3:
			update();			
			break;
		case 4:
			delete();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			break;
		
			}	
		}
	}
	
	int manager = 0, supervisor = 0, admin = 0;
	void insert() {
		
		String kode="";
		do {
		char randhuruf1;
		char randhuruf2;
		randhuruf1 = (char) (rand.nextInt(26) + 'A');
		randhuruf2 = (char) (rand.nextInt(26) + 'A');
		kode = " " + randhuruf1 + randhuruf2 + "-" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		if (!kodelist.contains(kode)) {
			kodelist.add(kode);
			break;
		}
		
		} while (true);
		
		do {
			System.out.print("Input nama karyawan [>=3]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = scan.nextLine();
		} while (!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor |  Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		
		switch (jabatan) {
		case "Manager":
			gaji = 8000000;
			break;
		case "Supervisor":
			gaji = 6000000;
			break;
		case "Admin":
			gaji = 4000000;
			break;
		default:
			break;
		}
		
		jabatanlist.add(jabatan);
		genderlist.add(gender);
		namalist.add(nama);
		gajilist.add(gaji);
		
			if (jabatan.equals("Manager")) {
				manager +=1;
			}
			if (jabatan.equals("Supervisor")) {
				supervisor +=1;
			}
			if (jabatan.equals("Admin")) {
				admin +=1;
			}
		
			
		int gajiUpdated = 0;
		
		if ((manager-1)%3 == 0 && manager != 1) {
			System.out.print("Bonus sebesar 10% diberikan kepada karyawan dengan ID ");
			
			for (int i = 0; i < jabatanlist.size(); i++) {
				int money = gajilist.get(i);
				if (jabatanlist.get(i).contains("Manager")) {
					int bonus = (int) (money * 0.10);
					money += bonus;
					gajilist.set(i, money);
					gajiUpdated++;
					if (gajiUpdated == manager - 1) {
						System.out.println(kodelist.get(i));
						break;
					} else {
						System.out.print(kodelist.get(i)+ ",");
					}
				}
			}
		}
					
		if ((supervisor-1)%3 == 0 && supervisor != 1) {
			System.out.print("Bonus sebesar 7.5% diberikan kepada karyawan dengan ID ");
			for (int j = 0; j < jabatanlist.size(); j++) {
			
				int money1 = gajilist.get(j);
				if (jabatanlist.get(j).contains("Supervisor")) {
					int bonus1 = (int) (money1 * 0.075);
					money1 += bonus1;
					gajilist.set(j, money1);
					gajiUpdated++;
					if (gajiUpdated == supervisor - 1) {
						System.out.println(kodelist.get(j));
						break;
					} else {
						System.out.print(kodelist.get(j)+ ",");
					}
				}
			}
		}
				
		if ((admin-1)%3 == 0 && admin != 1) {
			System.out.print("Bonus sebesar 5% diberikan kepada karyawan dengan ID ");
			for (int k = 0; k < jabatanlist.size(); k++) {
				int money2 = gajilist.get(k);
				if (jabatanlist.get(k).contains("Admin")) {
					int bonus2 = (int) (money2 * 0.05);
					money2 += bonus2;
					gajilist.set(k, money2);
					gajiUpdated++;
					if (gajiUpdated == admin - 1) {
						System.out.println(kodelist.get(k));
						break;
					} else {
						System.out.print(kodelist.get(k)+ ",");
					}
				
				}

			}
	
		}
		
        System.out.println("Data karyawan berhasil ditambahkan.");
		System.out.println("ENTER to return");
		scan.nextLine();
		
	}				
			
	void view() {
	    ascending();
	    System.out.println("-----------------------------------------------------------------------------------------------------------------");
	    System.out.println("| No| Kode Karyawan  | Nama Karyawan              | Jenis Kelamin| Jabatan       | Gaji Karyawan  |");
	    System.out.println("-----------------------------------------------------------------------------------------------------------------");
	    for (int i = 0; i < namalist.size(); i++) {
	        System.out.printf("| %2d| %14s | %26s | %12s | %13s | %13d |%n",
	                (i + 1), kodelist.get(i), namalist.get(i), genderlist.get(i), jabatanlist.get(i), gajilist.get(i));
	    }
	    System.out.println("-----------------------------------------------------------------------------------------------------------------");
	}

	void update() {
	    view();
	    int number = 0;
	    do {
	        System.out.println("Input nomor urutan karyawan yang ingin diupdate: ");
	        number = scan.nextInt();
	        scan.nextLine();
	    } while (number < 0 || number > namalist.size());

	    String newNama;
	    do {
	        System.out.println("Masukkan nama baru karyawan (>=): ");
	        newNama = scan.nextLine();
	    } while (newNama.length() < 3 && !newNama.equals("0"));

	    String newGender;
	    do {
	        System.out.println("Masukkan jenis kelamin baru karyawan (Laki-laki/Perempuan) (Case Sensitive): ");
	        newGender = scan.nextLine();
	    } while (!(newGender.equals("Laki-laki") || newGender.equals("Perempuan")) && !newGender.equals("0"));

	    String newJabatan;
	    do {
	        System.out.println("Masukkan jabatan baru karyawan (Manager/Supervisor/Admin) (Case Sensitive): ");
	        newJabatan = scan.nextLine();
	    } while (!(newJabatan.equals("Manager") || newJabatan.equals("Supervisor") || newJabatan.equals("Admin")) && !newJabatan.equals("0"));

	    if (!newNama.equals("0") || !newGender.equals("0") || !newJabatan.equals("0")) {
	        namalist.set(number - 1, newNama);
	        genderlist.set(number - 1, newGender);
	        jabatanlist.set(number - 1, newJabatan);
	    }
	    
	    if (jabatanlist.get(number - 1).equals("Manager")) {
            gajilist.set(number - 1, 8000000); // 
        } else if (jabatanlist.get(number - 1).equals("Supervisor")) {
            gajilist.set(number - 1, 6000000); 
        } else if (jabatanlist.get(number - 1).equals("Admin")) {
            gajilist.set(number - 1, 4000000); 
        }
	    
	    System.out.println("Berhasil mengupdate karyawan dengan id" + kodelist.get(number-1));
	    System.out.println("ENTER to return");
	    scan.nextLine();
	}
	
	void delete() {
		view();
		int nomor=0;
		do {
			System.out.println("Input nomor urutan karyawan yang ingin dihapus: ");
			nomor = scan.nextInt(); scan.nextLine();
		} while (nomor < 1 && nomor > namalist.size() );
		
		String deletedkode = kodelist.get(nomor-1);
		kodelist.remove(nomor-1);
		namalist.remove(nomor-1);
		genderlist.remove(nomor-1);
		jabatanlist.remove(nomor-1);
		gajilist.remove(nomor-1);
		
		System.out.println("Karyawan dengan kode" + deletedkode + "berhasil dihapus");
		System.out.println("ENTER to return");
		scan.nextLine();
	}
	
	void ascending() {
		for (int i = 0; i < namalist.size(); i++) {
			for (int j = 0; j < namalist.size()-i-1; j++) {
				if (namalist.get(j).compareTo(namalist.get(j + 1)) > 0) {
					String kode = kodelist.get(j);
					kodelist.set(j, kodelist.get(j + 1));
					kodelist.set(j + 1, kode);
					String nama = namalist.get(j);
					namalist.set(j, namalist.get(j + 1));
					namalist.set(j + 1, nama);
					String gender = genderlist.get(j);
					genderlist.set(j, genderlist.get(j + 1));
					genderlist.set(j + 1, gender);
					String jabatan = jabatanlist.get(j);
					jabatanlist.set(j, jabatanlist.get(j + 1));
					jabatanlist.set(j + 1, jabatan);
					Integer Gaji = gajilist.get(j);
	                gajilist.set(j, gajilist.get(j + 1));
	                gajilist.set(j + 1, Gaji);
				}
			}
		}
	}

	public static void main(String[] args) {
		new main();
	}

}
