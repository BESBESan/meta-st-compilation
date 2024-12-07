SUMMARY = "GCC ARM Embedded Toolchain"
DESCRIPTION = "Toolchain pour compiler du code bare-metal sur ARM Cortex-M"
LICENSE = "GPL-3.0"

# URL de téléchargement
SRC_URI = "https://developer.arm.com/-/media/Files/downloads/gnu-rm/10.3-2021.10/gcc-arm-none-eabi-10.3-2021.10-x86_64-linux.tar.bz2"
SRC_URI[sha256sum] = "8cf93fbc2a3a03bc51a3e233d70c1e5d8e3840a48bd2196c211c6e2674c61b16"

# Répertoire source
S = "${WORKDIR}/gcc-arm-none-eabi-10.3-2021.10"

# Installation dans l'environnement Yocto
do_install() {
    install -d ${D}${bindir}
    cp -r ${S}/* ${D}${bindir}
}

# Marquer comme natif pour que Yocto sache qu’il est utilisé comme toolchain
BBCLASSEXTEND = "native nativesdk"
