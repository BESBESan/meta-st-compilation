
SUMMARY = "STM32F407 Project with Makefile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=<checksum>"

# Chemin vers les fichiers source et Makefile
SRC_URI = "file://Makefile \
           file://stm32f407.ld \
           file://startup_stm32f407.s \
           file://core/src/"

# Répertoire de travail pour la compilation
S = "${WORKDIR}"

# Héritage du système de build Yocto basé sur Makefile
inherit build

# Définir les options spécifiques de compilation
EXTRA_OEMAKE = ""

# Cible de compilation
do_compile() {
    # Appel de make
    oe_runmake
}

# Cible d'installation
do_install() {
    # Installer le binaire généré dans le répertoire de destination
    install -d ${D}/opt/stm32
    install -m 0755 ${S}/your_output_binary ${D}/opt/stm32/
}

# Déclarer le fichier binaire généré comme artefact
FILES_${PN} += "/opt/stm32/your_output_binary"
