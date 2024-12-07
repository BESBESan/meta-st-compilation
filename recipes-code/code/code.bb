SUMMARY = "Code pour STM32F407"
DESCRIPTION = "Compilateur pour STM32F407 avec Makefile"
LICENSE = "CLOSED"

# Inclure les fichiers du projet
# Référence au Makefile et autres fichiers nécessaires dans un chemin local
SRC_URI = "file:///home/besbes/layers/GPIO_IOToggle/Makefile \
           file:///home/besbes/layers/GPIO_IOToggle/Src/main.c"

# Dépendance pour GCC ARM Embedded
DEPENDS += "gcc-arm-none-eabi-native"

# Spécification du compilateur et du linker
COMPILER = "${STAGING_DIR_NATIVE}/bin/arm-none-eabi-gcc"
LINKER = "${STAGING_DIR_NATIVE}/bin/arm-none-eabi-ld"

# Options de compilation
EXTRA_CFLAGS = "-mcpu=cortex-m4 -mthumb -g -O2"

# Options de linking
EXTRA_LDFLAGS = "-Tstm32f407.ld"

S = "${WORKDIR}/src"

# Installation
do_install() {
    install -d ${D}${bindir}/code
    cp -r ${S}/* ${D}${bindir}/code
}

# Fonction de compilation
do_compile() {
    # Compiler le fichier source en fichier objet
    ${COMPILER} ${EXTRA_CFLAGS} -c ${S}/main.c -o ${S}/main.o

    # Lier le fichier objet pour créer l'exécutable
    ${LINKER} ${EXTRA_LDFLAGS} ${S}/main.o -o ${S}/firmware.elf

    # Convertir l'exécutable en binaire
    arm-none-eabi-objcopy -O binary ${S}/firmware.elf ${S}/firmware.bin
}

# Produit final
do_deploy() {
    install -d ${DEPLOYDIR}
    cp ${S}/firmware.bin ${DEPLOYDIR}/
}

# Type d'image : génère un fichier binaire
IMAGE_FSTYPES = "bin"
