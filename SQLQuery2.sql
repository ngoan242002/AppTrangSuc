USE [master]
GO
/****** Object:  Database [TrangSuc]    Script Date: 05/04/2023 9:58:29 SA ******/
CREATE DATABASE [TrangSuc]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TrangSuc', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\TrangSuc.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TrangSuc_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\TrangSuc_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [TrangSuc] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TrangSuc].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TrangSuc] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TrangSuc] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TrangSuc] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TrangSuc] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TrangSuc] SET ARITHABORT OFF 
GO
ALTER DATABASE [TrangSuc] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TrangSuc] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TrangSuc] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TrangSuc] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TrangSuc] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TrangSuc] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TrangSuc] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TrangSuc] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TrangSuc] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TrangSuc] SET  DISABLE_BROKER 
GO
ALTER DATABASE [TrangSuc] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TrangSuc] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TrangSuc] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TrangSuc] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TrangSuc] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TrangSuc] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TrangSuc] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TrangSuc] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [TrangSuc] SET  MULTI_USER 
GO
ALTER DATABASE [TrangSuc] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TrangSuc] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TrangSuc] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TrangSuc] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [TrangSuc] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [TrangSuc] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [TrangSuc] SET QUERY_STORE = ON
GO
ALTER DATABASE [TrangSuc] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [TrangSuc]
GO
/****** Object:  User [NgoanNguyen]    Script Date: 05/04/2023 9:58:29 SA ******/
CREATE USER [NgoanNguyen] FOR LOGIN [NgoanNguyen] WITH DEFAULT_SCHEMA=[db_accessadmin]
GO
ALTER ROLE [db_owner] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_datareader] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [NgoanNguyen]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [NgoanNguyen]
GO
/****** Object:  Table [dbo].[HoaDonSanPham]    Script Date: 05/04/2023 9:58:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonSanPham](
	[MaHoaDon] [int] NOT NULL,
	[MaSanPham] [int] NOT NULL,
	[SoLuong] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonTaiKhoan]    Script Date: 05/04/2023 9:58:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonTaiKhoan](
	[MaHoaDon] [int] IDENTITY(1,1) NOT NULL,
	[TaiKhoan] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HoaDonTaiKhoan] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuanLySanPham]    Script Date: 05/04/2023 9:58:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuanLySanPham](
	[MaSanPham] [int] IDENTITY(1,1) NOT NULL,
	[TenSanPham] [nvarchar](50) NOT NULL,
	[GiaSanPham] [float] NOT NULL,
	[NgayNhap] [datetime] NOT NULL,
	[MoTa] [nvarchar](max) NULL,
	[NhaSanXuat] [nvarchar](max) NULL,
	[JsonStringBitmap] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_QuanLySanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 05/04/2023 9:58:29 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TaiKhoan] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](16) NOT NULL,
	[Email] [nvarchar](50) NULL,
	[PhanQuyen] [int] NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[QuanLySanPham] ON 

INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (2, N'ScreenShot', 1200, CAST(N'2023-03-22T00:00:00.000' AS DateTime), N'', N'', N'C:\Users\vipvl\Pictures\z4114089624291_c0f8c50a69e8939896d8d298957c158b.jpg')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (4, N'ScreenShot', 1200, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'', N'', N'D:\NguoiYeu\AppBanTrangSuc\src\res\pictures\sanpham\Screenshot.png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (6, N'ScreenShot', 1200, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'', N'', N'D:\NguoiYeu\AppBanTrangSuc\src\res\pictures\sanpham\Screenshot.png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (8, N'ScreenShotxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 1200, CAST(N'2023-03-23T00:00:00.000' AS DateTime), N'afafafafafafafafafa', N'', N'D:\NguoiYeu\AppBanTrangSuc\src\res\pictures\sanpham\Screenshot.png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (9, N'ScreenShot', 1200, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'', N'', N'D:\NguoiYeu\AppBanTrangSuc\src\res\pictures\sanpham\Screenshot.png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (10, N'ScreenShot', 1200, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'', N'', N'D:\NguoiYeu\AppBanTrangSuc\src\res\pictures\sanpham\Screenshot.png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (17, N'Alo alo', 300000, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'Ngoan Ngo', N'Hai Tran', N'C:\Users\vipvl\Pictures\Screenshots\Screenshot (4).png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (19, N'Ngoan Ngo', 1000000000000, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'Ny xinh gai ntn bao nta ngo', N'Hai Tran', N'C:\Users\vipvl\Pictures\Screenshots\Screenshot_20230208_084819.png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (27, N'????', 28525.352, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'jfbsksvmsbns me oiw the gioi menh mong', N'Hai Tran', N'C:\Users\vipvl\Pictures\Screenshots\Screenshot (9).png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (28, N'afbafalkaovjm', 1181041920, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'afnaJNABMLBKSNB  AF,FKN Zdkbkdbmosmbwm ', N'Hai Tran', N'C:\Users\vipvl\Pictures\Screenshots\Screenshot (14).png')
INSERT [dbo].[QuanLySanPham] ([MaSanPham], [TenSanPham], [GiaSanPham], [NgayNhap], [MoTa], [NhaSanXuat], [JsonStringBitmap]) VALUES (29, N'hahahaha', 189104144, CAST(N'2023-03-19T00:00:00.000' AS DateTime), N'afalfsnv8 n29sknksgi fskfmsio sofosmflf owj ofowmsg is is', N'Hai Tran', N'C:\Users\vipvl\Pictures\Screenshots\Screenshot (13).png')
SET IDENTITY_INSERT [dbo].[QuanLySanPham] OFF
GO
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Email], [PhanQuyen]) VALUES (N'abcd', N'1234', N'abcd@gmail.com', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Email], [PhanQuyen]) VALUES (N'accmoi1', N'accmoi1', N'accmoi1@gmail.com', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Email], [PhanQuyen]) VALUES (N'admin1', N'123456', N'abc@gmail.com', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Email], [PhanQuyen]) VALUES (N'master', N'1234', N'master@gmail.com', 0)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Email], [PhanQuyen]) VALUES (N'user1', N'123456', N'user1@gmail.com', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Email], [PhanQuyen]) VALUES (N'user2', N'1', N'x@gmail.com', 1)
INSERT [dbo].[TaiKhoan] ([TaiKhoan], [MatKhau], [Email], [PhanQuyen]) VALUES (N'user3', N'2', N'u3@gmail.com', 1)
GO
ALTER TABLE [dbo].[HoaDonSanPham]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonSanPham_HoaDonTaiKhoan] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDonTaiKhoan] ([MaHoaDon])
GO
ALTER TABLE [dbo].[HoaDonSanPham] CHECK CONSTRAINT [FK_HoaDonSanPham_HoaDonTaiKhoan]
GO
ALTER TABLE [dbo].[HoaDonSanPham]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonSanPham_QuanLySanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[QuanLySanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[HoaDonSanPham] CHECK CONSTRAINT [FK_HoaDonSanPham_QuanLySanPham]
GO
ALTER TABLE [dbo].[HoaDonTaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonTaiKhoan_TaiKhoan] FOREIGN KEY([TaiKhoan])
REFERENCES [dbo].[TaiKhoan] ([TaiKhoan])
GO
ALTER TABLE [dbo].[HoaDonTaiKhoan] CHECK CONSTRAINT [FK_HoaDonTaiKhoan_TaiKhoan]
GO
USE [master]
GO
ALTER DATABASE [TrangSuc] SET  READ_WRITE 
GO
