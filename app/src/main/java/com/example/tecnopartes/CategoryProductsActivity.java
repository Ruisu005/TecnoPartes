package com.example.tecnopartes;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductsAdapter adapter;
    private List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category_products);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String category = getIntent().getStringExtra("category");

        TextView textViewCategory = findViewById(R.id.textViewCategory);
        textViewCategory.setText(category);

        recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = getProductsForCategory(category);
        adapter = new ProductsAdapter(productList);
        recyclerView.setAdapter(adapter);
    }

    private List<Product> getProductsForCategory(String category) {
        List<Product> products = new ArrayList<>();

        if (category.equals("Procesadores")) {
            products.add(new Product("AMD Ryzen 5 5600X", "Procesador de gama media para juegos y tareas multitarea.", 2739, R.drawable.ryzen_5_5600x));
            products.add(new Product("Intel Core i7-10700K", "Procesador de gama media para juegos y tareas multitarea.", 5797, R.drawable.i7_10700k));
            products.add(new Product("AMD Ryzen 7 5800X", "Procesador de alto rendimiento para juegos y aplicaciones de productividad.", 3757, R.drawable.ryzen_7_5800x));
            products.add(new Product("Intel Core i5-10400F", "Procesador de gama media sin gráficos integrados.", 3199, R.drawable.i5_10400f));
            products.add(new Product("AMD Ryzen 9 5950X", "Procesador de gama alta para estaciones de trabajo y juegos extremos.", 7519, R.drawable.ryzen_9_5950x));
            products.add(new Product("Intel Core i9-10900K", "Procesador de alto rendimiento para juegos y creación de contenido.", 7957, R.drawable.i9_10900k));
            products.add(new Product("AMD Ryzen 3 3300X", "Procesador económico para tareas básicas y juegos ligeros.", 2299, R.drawable.ryzen_3_3300x));
            products.add(new Product("Intel Core i5-11600K", "Procesador de gama media con buena relación precio-rendimiento.", 4199, R.drawable.i5_11600k));
            products.add(new Product("AMD Ryzen 5 3600", "Procesador de gama media para juegos y tareas diarias.", 3652, R.drawable.ryzen_5_3600));
            products.add(new Product("Intel Core i3-10100", "Procesador económico para tareas básicas y juegos ligeros.", 2199, R.drawable.i3_10100));
        } else if (category.equals("Tarjetas Gráficas")) {
            products.add(new Product("NVIDIA GeForce RTX 3060 Ti", "Tarjeta gráfica de gama media-alta para juegos en 1440p.", 13675, R.drawable.rtx_3060_ti));
            products.add(new Product("AMD Radeon RX 6800", "Tarjeta gráfica de alto rendimiento para juegos en 4K.", 26742, R.drawable.rx_6800));
            products.add(new Product("NVIDIA GeForce RTX 3070", "Tarjeta gráfica de gama media-alta para juegos en 1440p y 4K.", 13581, R.drawable.rtx_3070));
            products.add(new Product("AMD Radeon RX 6700 XT", "Tarjeta gráfica de gama media para juegos en 1440p.", 23255, R.drawable.rx_6700_xt));
            products.add(new Product("NVIDIA GeForce GTX 1660 Super", "Tarjeta gráfica de gama media para juegos en 1080p.", 6417, R.drawable.gtx_1660_super));
            products.add(new Product("AMD Radeon RX 5600 XT", "Tarjeta gráfica de gama media para juegos en 1080p.", 4164, R.drawable.rx_5600_xt));
            products.add(new Product("NVIDIA GeForce RTX 3090", "Tarjeta gráfica de alta gama para juegos en 4K y tareas profesionales.", 32043, R.drawable.rtx_3090));
            products.add(new Product("AMD Radeon RX 5500 XT", "Tarjeta gráfica de gama media-baja para juegos en 1080p.", 8105, R.drawable.rx_5500_xt));
            products.add(new Product("NVIDIA GeForce RTX 2060", "Tarjeta gráfica de gama media-alta para juegos en 1080p y 1440p.", 8016, R.drawable.rtx_2060));
            products.add(new Product("AMD Radeon RX 6900 XT", "Tarjeta gráfica de alta gama para juegos en 4K.", 47712, R.drawable.rx_6900_xt));
        } else if (category.equals("RAM")) {
            products.add(new Product("Kingston HyperX Fury 16GB (2 x 8GB) DDR4 3200MHz", "Kit de memoria RAM de alto rendimiento.", 932, R.drawable.hyperx_fury_16gb_kit));
            products.add(new Product("Corsair Vengeance LPX 32GB (2 x 16GB) DDR4 3600MHz", "Kit de memoria RAM para tareas intensivas y multitarea.", 2899, R.drawable.vengeance_lpx_32gb));
            products.add(new Product("G.Skill Ripjaws V 16GB (2 x 8GB) DDR4 3000MHz", "Kit de memoria RAM con buena relación precio-rendimiento.", 1165, R.drawable.g_skill_ripjaws_v_16gb));
            products.add(new Product("Crucial Ballistix 16GB (2 x 8GB) DDR4 3200MHz", "Kit de memoria RAM con disipador de calor integrado.", 2499, R.drawable.crucial_ballistix_16gb));
            products.add(new Product("Corsair Dominator Platinum RGB 32GB (2 x 16GB) DDR4 3200MHz", "Memoria RAM de alto rendimiento con iluminación RGB.", 2699, R.drawable.dominator_platinum_rgb_32gb));
            products.add(new Product("Team T-Force Delta RGB 16GB (2 x 8GB) DDR4 3000MHz", "Memoria RAM con iluminación RGB personalizable.", 1790, R.drawable.team_t_force_delta_rgb_16gb));
            products.add(new Product("Patriot Viper 4 Blackout 16GB (2 x 8GB) DDR4 3600MHz", "Kit de memoria RAM de alto rendimiento para gamers.", 1558, R.drawable.viper_4_blackout_16gb));
            products.add(new Product("ADATA XPG Spectrix D60G 16GB (2 x 8GB) DDR4 3200MHz", "Memoria RAM con iluminación RGB y diseño único.", 1299, R.drawable.spectrix_d60g_16gb));
            products.add(new Product("G.Skill Trident Z RGB 32GB (2 x 16GB) DDR4 3200MHz", "Memoria RAM de alto rendimiento con iluminación RGB.", 1922, R.drawable.g_skill_trident_z_rgb_32gb));
            products.add(new Product("Thermaltake ToughRAM RGB 16GB (2 x 8GB) DDR4 3600MHz", "Memoria RAM con iluminación RGB y buen rendimiento.", 2800, R.drawable.thermaltake_toughram_rgb_16gb));
        } else if (category.equals("Tarjetas Madres")) {
            products.add(new Product("ASUS TUF Gaming B550-PLUS", "Tarjeta madre de gama media con soporte para AMD Ryzen.", 3399, R.drawable.tuf_gaming_b550_plus));
            products.add(new Product("MSI MPG Z490 Gaming Edge WiFi", "Tarjeta madre de gama alta para procesadores Intel.", 3563, R.drawable.mpg_z490_gaming_edge_wifi));
            products.add(new Product("Gigabyte X570 AORUS Elite", "Tarjeta madre de gama alta con soporte para AMD Ryzen y PCIe 4.0.", 6849, R.drawable.gigabyte_x570_aorus_elite));
            products.add(new Product("ASRock B450M Steel Legend", "Tarjeta madre de gama media-baja para AMD Ryzen.", 6012, R.drawable.asrock_b450m_steel_legend));
            products.add(new Product("MSI B450 TOMAHAWK MAX", "Tarjeta madre de gama media con buena relación calidad-precio.", 4792, R.drawable.msi_b450_tomahawk_max));
            products.add(new Product("ASUS Prime Z390-A", "Tarjeta madre de gama alta para procesadores Intel.", 3253, R.drawable.asus_prime_z390_a));
            products.add(new Product("Gigabyte B460M DS3H", "Tarjeta madre de gama media-baja para procesadores Intel.", 1899, R.drawable.gigabyte_b460m_ds3h));
            products.add(new Product("ASRock X570 Phantom Gaming 4", "Tarjeta madre de gama media para procesadores AMD Ryzen.", 2003, R.drawable.asrock_x570_phantom_gaming_4));
            products.add(new Product("MSI MEG Z590 ACE", "Tarjeta madre de alta gama para entusiastas de Intel.", 3622, R.drawable.msi_meg_z590_ace));
            products.add(new Product("ASUS ROG Strix B450-F Gaming", "Tarjeta madre de gama media con características gaming.", 3182, R.drawable.rog_strix_b450_f_gaming));
        } else if (category.equals("Gabinetes")) {
            products.add(new Product("NZXT H510", "Gabinete compacto y elegante con panel lateral de vidrio templado.", 724, R.drawable.nzxt_h510));
            products.add(new Product("Corsair 4000D Airflow", "Gabinete con excelente flujo de aire y diseño moderno.", 1649, R.drawable.corsair_4000d_airflow));
            products.add(new Product("Cooler Master MasterBox Q300L", "Gabinete compacto y versátil con excelente ventilación.", 1269, R.drawable.cooler_master_masterbox_q300l));
            products.add(new Product("Phanteks Eclipse P400A", "Gabinete con panel frontal de malla para un mejor flujo de aire.", 2599, R.drawable.phanteks_eclipse_p400a));
            products.add(new Product("Fractal Design Meshify C", "Gabinete con diseño angular y excelente flujo de aire.", 2631, R.drawable.fractal_design_meshify_c));
            products.add(new Product("Lian Li PC-O11 Dynamic", "Gabinete espacioso con paneles de vidrio templado.", 3047, R.drawable.lian_li_pc_o11_dynamic));
            products.add(new Product("Thermaltake Core P3", "Gabinete abierto con soporte para montaje en pared.", 3999, R.drawable.thermaltake_core_p3));
            products.add(new Product("Be Quiet! Pure Base 500DX", "Gabinete con excelente aislamiento acústico y flujo de aire.", 2285, R.drawable.be_quiet_pure_base_500dx));
            products.add(new Product("Corsair Obsidian Series 500D", "Gabinete premium con paneles de vidrio templado y aluminio.", 4664, R.drawable.corsair_obsidian_series_500d));
            products.add(new Product("NZXT H710", "Gabinete espacioso con gestión de cables optimizada.", 3499, R.drawable.nzxt_h710));
        } else if (category.equals("Almacenamiento")) {
            products.add(new Product("Samsung 970 EVO Plus 1TB NVMe M.2", "Unidad SSD de alta velocidad para almacenamiento rápido y eficiente.", 1899, R.drawable.evo_plus_1tb_nvme));
            products.add(new Product("WD Black SN750 1TB NVMe M.2", "SSD de alto rendimiento para juegos y aplicaciones.", 1218, R.drawable.wd_black_sn750_1tb_nvme));
            products.add(new Product("Crucial MX500 1TB SATA 2.5\"", "SSD fiable y rápido para almacenamiento general.", 1799, R.drawable.crucial_mx500_1tb_sata_2_5));
            products.add(new Product("Kingston A2000 1TB NVMe M.2", "SSD económico y rápido para mejorar el rendimiento del sistema.", 3559, R.drawable.kingston_a2000_1tb_nvme));
            products.add(new Product("Seagate Barracuda 2TB HDD", "Disco duro de alta capacidad para almacenamiento masivo.", 1078, R.drawable.seagate_barracuda_2tb_hdd));
            products.add(new Product("Samsung 860 EVO 1TB SATA 2.5\"", "SSD de alto rendimiento para almacenamiento rápido.", 4399, R.drawable.samsung_860_evo_1tb_sata_2_5));
            products.add(new Product("ADATA XPG SX8200 Pro 1TB NVMe M.2", "SSD rápido y fiable para juegos y aplicaciones.", 1743, R.drawable.xpg_sx8200_pro_1tb_nvme));
            products.add(new Product("Toshiba X300 4TB HDD", "Disco duro de alta capacidad para almacenamiento masivo.", 3299, R.drawable.toshiba_x300_4tb_hdd));
            products.add(new Product("Intel 660p 1TB NVMe M.2", "SSD económico con buen rendimiento para uso general.", 1987, R.drawable.intel_660p_1tb_nvme));
            products.add(new Product("Crucial P1 1TB NVMe M.2", "SSD de buena relación calidad-precio para mejorar el rendimiento del sistema.", 2999, R.drawable.crucial_p1_1tb_nvme));
        } else if (category.equals("Enfriamiento de Aire")) {
            products.add(new Product("Cooler Master Hyper 212 EVO", "Enfriador de aire para CPU con rendimiento eficiente y diseño de torre.", 694, R.drawable.cooler_master_hyper_212_evo));
            products.add(new Product("Noctua NH-D15", "Enfriador de aire de alto rendimiento con doble torre y doble ventilador.", 2599, R.drawable.noctua_nh_d15));
            products.add(new Product("be quiet! Dark Rock Pro 4", "Enfriador de aire silencioso y de alto rendimiento.", 2118, R.drawable.be_quiet_dark_rock_pro_4));
            products.add(new Product("DeepCool Gammaxx 400", "Enfriador de aire económico y eficiente.", 599, R.drawable.deepcool_gammaxx_400));
            products.add(new Product("Cryorig H7", "Enfriador de aire compacto y eficiente.", 651, R.drawable.cryorig_h7));
            products.add(new Product("Thermaltake UX200", "Enfriador de aire con iluminación RGB y buen rendimiento.", 779, R.drawable.thermaltake_ux200));
            products.add(new Product("Scythe Fuma 2", "Enfriador de aire de doble torre y doble ventilador.", 4425, R.drawable.scythe_fuma_2));
            products.add(new Product("Arctic Freezer 34 eSports DUO", "Enfriador de aire con doble ventilador para mayor eficiencia.", 1175, R.drawable.arctic_freezer_34_esports_duo));
            products.add(new Product("Noctua NH-U12S", "Enfriador de aire compacto y silencioso.", 1729, R.drawable.noctua_nh_u12s));
            products.add(new Product("Cooler Master MasterAir MA410M", "Enfriador de aire con iluminación RGB y buen rendimiento.", 1159, R.drawable.cooler_master_masterair_ma410m));
        } else if (category.equals("Enfriamiento Líquido")) {
            products.add(new Product("Corsair Hydro Series H100i RGB PLATINUM", "Sistema de enfriamiento líquido todo en uno con iluminación RGB.", 5429, R.drawable.hydro_series_h100i_rgb_platinum));
            products.add(new Product("NZXT Kraken X63", "Sistema de enfriamiento líquido de alto rendimiento con iluminación RGB.", 2999, R.drawable.nzxt_kraken_x63));
            products.add(new Product("Cooler Master MasterLiquid ML240R RGB", "Enfriamiento líquido con iluminación RGB y buen rendimiento.", 2599, R.drawable.masterliquid_ml240r_rgb));
            products.add(new Product("EVGA CLC 280", "Enfriamiento líquido de alto rendimiento para CPUs exigentes.", 4838, R.drawable.evga_clc_280));
            products.add(new Product("Thermaltake Floe Riing RGB 360 TT Premium", "Enfriamiento líquido con radiador de 360 mm e iluminación RGB.", 3746, R.drawable.thermaltake_floe_riing_rgb_360_tt_premium));
            products.add(new Product("Corsair Hydro Series H150i PRO RGB", "Sistema de enfriamiento líquido con radiador de 360 mm e iluminación RGB.", 2829, R.drawable.hydro_series_h150i_pro_rgb));
            products.add(new Product("DeepCool Castle 360EX", "Enfriamiento líquido con diseño elegante e iluminación RGB.", 1929, R.drawable.deepcool_castle_360ex));
            products.add(new Product("Asus ROG Strix LC 240 RGB", "Sistema de enfriamiento líquido con radiador de 240 mm e iluminación RGB.", 3450, R.drawable.rog_strix_lc_240_rgb));
            products.add(new Product("Cooler Master MasterLiquid ML360R RGB", "Enfriamiento líquido con radiador de 360 mm e iluminación RGB.", 1994, R.drawable.masterliquid_ml360r_rgb));
            products.add(new Product("Arctic Liquid Freezer II 280", "Sistema de enfriamiento líquido eficiente y silencioso.", 3031, R.drawable.arctic_liquid_freezer_ii_280));
        } else if (category.equals("Fuentes de Poder")) {
            products.add(new Product("Corsair RM750x 750W 80+ Gold", "Fuente de poder de alta eficiencia y calidad.", 2649, R.drawable.corsair_rm750x_750w_80_gold));
            products.add(new Product("EVGA SuperNOVA 750 G3 750W 80+ Gold", "Fuente de poder de alta eficiencia y rendimiento.", 1795, R.drawable.evga_supernova_750_g3_750w_80_gold));
            products.add(new Product("Seasonic Focus GX-750 750W 80+ Gold", "Fuente de poder compacta y eficiente.", 2411, R.drawable.seasonic_focus_gx_750_80_gold));
            products.add(new Product("Cooler Master MWE Gold 650W 80+ Gold", "Fuente de poder eficiente y económica.", 2258, R.drawable.cooler_master_mwe_gold_650w_80_gold));
            products.add(new Product("Thermaltake Toughpower GF1 850W 80+ Gold", "Fuente de poder de alta capacidad y eficiencia.", 2093, R.drawable.thermaltake_toughpower_gf1_850w_80_gold));
            products.add(new Product("Corsair CX550M 550W 80+ Bronze", "Fuente de poder de buena calidad y eficiencia.", 1193, R.drawable.corsair_cx550m_550w_80_bronze));
            products.add(new Product("EVGA 600 W1 600W 80+ White", "Fuente de poder económica y fiable.", 3999, R.drawable.evga_600_w1_600w_80_white));
            products.add(new Product("Be Quiet! Straight Power 11 750W 80+ Platinum", "Fuente de poder silenciosa y eficiente.", 2630, R.drawable.be_quiet_straight_power_11_750w_80_platinum));
            products.add(new Product("Cooler Master V850 850W 80+ Gold", "Fuente de poder de alta capacidad y rendimiento.", 3916, R.drawable.cooler_master_v850_850w_80_gold));
            products.add(new Product("NZXT C650 650W 80+ Gold", "Fuente de poder eficiente y compacta.", 2579, R.drawable.nzxt_c650_650w_80_gold));
        } else if (category.equals("Ventiladores")) {
            products.add(new Product("Noctua NF-A12x25 PWM", "Ventilador de alto rendimiento y bajo nivel de ruido.", 749, R.drawable.noctua_nf_a12x25_pwm));
            products.add(new Product("Corsair ML120 PRO RGB", "Ventilador con tecnología magnética para mejor rendimiento y RGB.", 630, R.drawable.corsair_ml120_pro_rgb));
            products.add(new Product("NZXT Aer RGB 2", "Ventilador RGB con diseño aerodinámico para mejor flujo de aire.", 599, R.drawable.nzxt_aer_rgb_2));
            products.add(new Product("Cooler Master MasterFan MF120R ARGB", "Ventilador con iluminación ARGB y rendimiento eficiente.", 299, R.drawable.cooler_master_masterfan_mf120r_argb));
            products.add(new Product("be quiet! Silent Wings 3", "Ventilador ultra silencioso con alto rendimiento.", 308, R.drawable.be_quiet_silent_wings_3));
            products.add(new Product("Thermaltake Riing Plus 12 RGB", "Ventilador con anillo de iluminación RGB y buen flujo de aire.", 749, R.drawable.thermaltake_riing_plus_12_rgb));
            products.add(new Product("Arctic P12 PWM", "Ventilador eficiente y silencioso con control PWM.", 365, R.drawable.arctic_p12_pwm));
            products.add(new Product("Phanteks PH-F120MP", "Ventilador de alta presión estática para radiadores y disipadores.", 399, R.drawable.phanteks_ph_f120mp));
            products.add(new Product("DeepCool RF120M", "Ventilador con iluminación RGB y rendimiento equilibrado.", 270, R.drawable.deepcool_rf120m)); // Precio no proporcionado
            products.add(new Product("Lian Li UNI Fan SL120", "Ventilador modular con iluminación ARGB y alto rendimiento.", 610, R.drawable.lian_li_uni_fan_sl120));
        }

        return products;
    }
}