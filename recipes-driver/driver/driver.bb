DESCRIPTION = "STM32 HAL and LL drivers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=<checksum>"

SRC_URI = "git://github.com/STMicroelectronics/stm32u5xx-hal-driver.git;protocol=http;branch=main"
SRCREV = "5f3b1924e386eb80963e1a8ec382ad08902e2a0d"

S = "${WORKDIR}/git"

do_compile() {
    # Pas besoin de compilation, juste copier les fichiers nécessaires
    :
}

do_install() {
    install -d ${D}/drivers
    cp -r ${S}/Drivers/STM32F4xx_HAL_Driver ${D}/drivers/
    cp -r ${S}/Drivers/CMSIS ${D}/drivers/
}

FILES_${PN} = "/drivers"


