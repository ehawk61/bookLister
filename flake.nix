{
  description = "Developer env for bookLister";
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
  };
  outputs = { self, nixpkgs }:
   let
    supportedSystems = [
     "aarch64-darwin"
     "aarch64-linux"
     "x86_64-darwin"
     "x86_64-linux"
    ];
   
   forAllSupportedSystems = f: nixpkgs.lib.genAttrs supportedSystems (system: f {
     pkgs = import nixpkgs { inherit system; };
   });
  in
  {
    devShells = forAllSupportedSystems ({ pkgs }: {
      default = pkgs.mkShell {
	buildInputs = [
	  pkgs.sqlite
          pkgs.sqlitebrowser
          pkgs.redocly
          pkgs.jdk_headless
          pkgs.maven
        ];

        shellHook = ''
          export _JAVA_OPTIONS='-Dawt.useSystemAAFontSettings=lcd' 
        '';
      };
   });
  };
}
