{ pkgs ? import <nixpkgs> {} }:
  pkgs.mkShell {
    nativeBuildInputs = with pkgs.buildPackages; [ sqlite sqlitebrowser redocly jdk_headless maven ];
}
