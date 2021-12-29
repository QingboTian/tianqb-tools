package cn.tianqb.ext;

public interface DataSourceParamInitExt extends ExtensionPoint<DataSourceParamInitExt> {

    @Override
    default DataSourceParamInitExt getDefault() {
        return null;
    }
}
