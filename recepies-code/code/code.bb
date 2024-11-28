SUMMARY = "Crunch chat application"
DESCRIPTION = "Crunch is a simple chat application"
HOMEPAGE = "https://github.com/pri1311/crunch"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE;md5=REPLACE_WITH_ACTUAL_MD5"

SRC_URI = "file://main.c"


S = "${WORKDIR}/code"


RDEPENDS:${PN} += "main.h"


SRC_URI += "file://requirements.txt"

do_install() {
    # Copy the application source files
    install -d ${D}${bindir}/code
    cp -r ${S}/* ${D}${bindir}/code
}

#do_install_append() { pip3 install -r ${WORKDIR}/requirements.txt --target=${D}${PYTHON_SITEPACKAGES_DIR}
}
