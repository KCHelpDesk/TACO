;This file will be executed next to the application bundle image
;I.e. current directory will contain folder KChelpDesk Tool with application files
[Setup]
AppId={{fxApplication}}
AppName=KChelpDesk Tool
AppVersion=1.0.0.0
AppVerName=KChelpDesk Tool 1.0.0.1
AppPublisher=KCHelpDesk
AppComments=TACO
AppCopyright=Copyright (C) 2016
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={pf}\KChelpDesk Tool
DisableStartupPrompt=Yes
DisableDirPage=Yes
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=Yes
DisableWelcomePage=Yes
DefaultGroupName=KCHelpDesk
;Optional License
LicenseFile=
;WinXP or above
MinVersion=0,5.1 
OutputBaseFilename=KChelpDesk Tool-1.0.0.1
Compression=lzma
SolidCompression=yes
PrivilegesRequired=admin
SetupIconFile=KChelpDesk Tool\KChelpDesk Tool.ico
UninstallDisplayIcon={app}\KChelpDesk Tool.ico
UninstallDisplayName=KChelpDesk Tool
WizardImageStretch=No
WizardSmallImageFile=KChelpDesk Tool-setup-icon.bmp   
ArchitecturesInstallIn64BitMode=x64


[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "KChelpDesk Tool\KChelpDesk Tool.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "KChelpDesk Tool\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\KChelpDesk Tool"; Filename: "{app}\KChelpDesk Tool.exe"; IconFilename: "{app}\KChelpDesk Tool.ico"; Check: returnTrue()
Name: "{commondesktop}\KChelpDesk Tool"; Filename: "{app}\KChelpDesk Tool.exe";  IconFilename: "{app}\KChelpDesk Tool.ico"; Check: returnTrue()


[Run]
Filename: "{app}\KChelpDesk Tool.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\KChelpDesk Tool.exe"; Description: "{cm:LaunchProgram,KChelpDesk Tool}"; Flags: nowait runascurrentuser skipifsilent; Check: returnTrue()
Filename: "{app}\KChelpDesk Tool.exe"; Parameters: "-install -svcName ""KChelpDesk Tool"" -svcDesc ""KChelpDesk Tool"" -mainExe ""KChelpDesk Tool.exe""  "; Flags: runascurrentuser; Check: returnFalse()

[UninstallRun]
Filename: "{app}\KChelpDesk Tool.exe "; Parameters: "-uninstall -svcName KChelpDesk Tool -stopOnUninstall"; Check: returnFalse()

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  
